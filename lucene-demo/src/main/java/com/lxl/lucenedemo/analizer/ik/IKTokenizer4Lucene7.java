package com.lxl.lucenedemo.analizer.ik;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;

/**
 * TokenStream 的两类子类
     * Tokenizer：分词器，输入是Reader字符流的TokenStream，完成从流中分出分项
     * TokenFilter：分项过滤器，它的输入是另一个TokenStream，完成对从上一个TokenStream中流出的token的特殊处理。
 * 自定义分词器作用：
 *  1. 将文档分成一个一个单独的单词。
    2. 去除标点符号。
    3. 去除停词(Stop word) 。
    经过分词(Tokenizer) 后得到的结果称为词元(Token) ，词元是文本最小切割单位，对于英文就是每一个单词，对于中文就是每一个汉字
    词元需要经过再次处理，比如变大写为小写，(Student/Students)->(student),处理之后生成结果Term（词）
    Token  Attribute： 分项属性（分项的信息）：如 包含的词、位置等
 * @author lxl lukas
 * @description
 * @create 2018/4/28
 */
public class IKTokenizer4Lucene7 extends Tokenizer{

    private IKSegmenter _IKSegmenter;
    //词元文本属性
    private final CharTermAttribute termAttribute;
    //词元位移属性
    private final OffsetAttribute offsetAttribute;
    //xx类型属性
    private final TypeAttribute typeAttribute;
    //记录最后一个词元的结束位置
    private int endPosition;

    public IKTokenizer4Lucene7(boolean userSmart) {
        super();
        termAttribute = addAttribute(CharTermAttribute.class);
        offsetAttribute = addAttribute(OffsetAttribute.class);
        typeAttribute = addAttribute(TypeAttribute.class);
        _IKSegmenter = new IKSegmenter(input, userSmart);
    }


    @Override
    public boolean incrementToken() throws IOException {
        clearAttributes();//清除所有词元属性
        Lexeme lx = _IKSegmenter.next();
        if(lx != null){//将Lexeme转为Attributes
            //设置词元内容 长度
            termAttribute.append(lx.getLexemeText());
            termAttribute.setLength(lx.getLength());
            //设置词元位移
            offsetAttribute.setOffset(lx.getBeginPosition(),lx.getEndPosition());
            endPosition = lx.getEndPosition();
            //设置词元分类
            typeAttribute.setType(lx.getLexemeTypeString());
            return true;
        }
        //false代表词元输出完毕
        return false;

    }

    @Override
    public void reset() throws IOException {
        super.reset();

        _IKSegmenter.reset(input);
    }

    @Override
    public void end() throws IOException {
       int finalOffset = correctOffset(this.endPosition);
       offsetAttribute.setOffset(finalOffset,finalOffset);
    }
}
