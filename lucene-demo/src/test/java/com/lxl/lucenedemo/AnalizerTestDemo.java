package com.lxl.lucenedemo;

import com.lxl.lucenedemo.analizer.ik.IKAnalyzer4Lucene7;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

/**
 * @author lxl lukas
 * @description
 * @create 2018/4/28
 */
public class AnalizerTestDemo {

    private static void doToken(TokenStream ts) throws IOException {
        ts.reset();
        CharTermAttribute cta = ts.getAttribute(CharTermAttribute.class);
        while (ts.incrementToken()) {
            System.out.print(cta.toString() + "|");
        }
        System.out.println();
        ts.end();
        ts.close();
    }

    public static void main(String[] args) throws IOException {
        String etext = "Analysis is one of the main causes of slow indexing. Simply put, the more you analyze the slower analyze the indexing (in most cases).";
        String chineseText = "张三说的确实在理。";

        try(Analyzer ana = new StandardAnalyzer();){
            TokenStream ts = ana.tokenStream("content",etext);
            System.out.println("标准分词器，英文分词效果：");
            doToken(ts);

            ts = ana.tokenStream("content", chineseText);
            System.out.println("标准分词器，中文分词效果：");
            doToken(ts);
        }

        System.out.println("--------------------------------");

        try (Analyzer smart = new SmartChineseAnalyzer();) {
            TokenStream ts = smart.tokenStream("content", etext);
            System.out.println("smart中文分词器，英文分词效果：");
            doToken(ts);
            ts = smart.tokenStream("content", chineseText);
            System.out.println("smart中文分词器，中文分词效果：");
            doToken(ts);
        }

        System.out.println("--------------------------------");
        // IKAnalyzer 细粒度切分
        try (Analyzer ik = new IKAnalyzer4Lucene7();) {
            TokenStream ts = ik.tokenStream("content", etext);
            System.out.println("IKAnalyzer中文分词器 细粒度切分，英文分词效果：");
            doToken(ts);
            ts = ik.tokenStream("content", chineseText);
            System.out.println("IKAnalyzer中文分词器 细粒度切分，中文分词效果：");
            doToken(ts);
        }
        System.out.println("--------------------------------");
        // IKAnalyzer 智能切分
        try (Analyzer ik = new IKAnalyzer4Lucene7(true);) {
            TokenStream ts = ik.tokenStream("content", etext);
            System.out.println("IKAnalyzer中文分词器 智能切分，英文分词效果：");
            doToken(ts);
            ts = ik.tokenStream("content", chineseText);
            System.out.println("IKAnalyzer中文分词器 智能切分，中文分词效果：");
            doToken(ts);
        }




        etext = "Analysis is one of the main causes of slow indexing. Simply put, ";
        chineseText = "厉害了我的国一经播出，受到各方好评，强烈激发了国人的爱国之情、自豪感！";
        // IKAnalyzer 细粒度切分
        try (Analyzer ik = new IKAnalyzer4Lucene7();) {
            TokenStream ts = ik.tokenStream("content", etext);
            System.out.println("IKAnalyzer中文分词器 细粒度切分，英文分词效果：");
            doToken(ts);
            ts = ik.tokenStream("content", chineseText);
            System.out.println("IKAnalyzer中文分词器 细粒度切分，中文分词效果：");
            doToken(ts);
        }

        // IKAnalyzer 智能切分
        try (Analyzer ik = new IKAnalyzer4Lucene7(true);) {
            TokenStream ts = ik.tokenStream("content", etext);
            System.out.println("IKAnalyzer中文分词器 智能切分，英文分词效果：");
            doToken(ts);
            ts = ik.tokenStream("content", chineseText);
            System.out.println("IKAnalyzer中文分词器 智能切分，中文分词效果：");
            doToken(ts);
        }


    }


}
