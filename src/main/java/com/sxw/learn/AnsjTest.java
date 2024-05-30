package com.sxw.learn;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class AnsjTest {
    public static void main(String[] args) {
        // 增加新词,中间按照'\t'隔开
        DicLibrary.insert(DicLibrary.DEFAULT, "名创优品");//设置自定义分词
        DicLibrary.insert(DicLibrary.DEFAULT, "理想");//设置自定义分词
        DicLibrary.insert(DicLibrary.DEFAULT, "苹果");//设置自定义分词

        String str = "浪漫生活的记录者";
        str = str.replaceAll("话题", "")
                .replaceAll("\\[\\]", "");

        String[] split = str.split("#");
        Arrays.stream(split).forEach(e -> {
            if (!StringUtils.isBlank(e)){
                System.out.println(e);
                Result parse = NlpAnalysis.parse(e);

                List<Term> terms = parse.getTerms();
                for (Term term : terms) {
                    System.out.println(term.getName());
                    System.out.println(term.getNatureStr());

                }
                System.out.println(parse);
            }
        });


    }
}
