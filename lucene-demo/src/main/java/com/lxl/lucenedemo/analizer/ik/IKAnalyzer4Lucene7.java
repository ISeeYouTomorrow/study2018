package com.lxl.lucenedemo.analizer.ik;

import org.apache.lucene.analysis.Analyzer;

/**
 * 自定义分析器:构建真正对文本进行分词处理的TokenStream（分词处理器）
 * @author lxl lukas
 * @description
 * @create 2018/4/28
 */
public class IKAnalyzer4Lucene7 extends Analyzer{
    private boolean useSmart = false;

    public IKAnalyzer4Lucene7() {
        this(false);
    }

    public IKAnalyzer4Lucene7(boolean useSmart) {
        super();
        this.useSmart = useSmart;
    }

    public boolean isUseSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    /**
     *
     * @param fieldName 如果需要对不同的字段创建不同的分词处理器组件，则使用
     * @return
     */
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        IKTokenizer4Lucene7 tk = new IKTokenizer4Lucene7(this.useSmart);
        return new TokenStreamComponents(tk);
    }
}
