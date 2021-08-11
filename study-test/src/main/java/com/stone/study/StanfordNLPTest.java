package com.stone.study;

import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.Collection;
import java.util.Properties;

/**
 * @ClassName: StanfordNLPTest
 * @Desc: 参考：
 * https://blog.csdn.net/weixin_34613450/article/details/84317158
 * https://stanfordnlp.github.io/
 * @Auther: shitao
 * @Date: 2021/08/10 09:56
 * @Version: 1.0
 * @Modified By:
 */
public class StanfordNLPTest {
    /**
     * 对一段句子进行分词（word_tokenize）、词性标注（pos_tag）、命名实体识别（ner）、句法依存分析（dependency_parse）、句法解析（parse）
     */
    public static void main(String[] args) {
//        String text = "Marie was born in Paris.";
//        // set up pipeline properties
//        Properties props = new Properties();
//        // set the list of annotators to run
//        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,depparse");
//        // build pipeline
//        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
//        // create a document object
//        CoreDocument document = pipeline.processToCoreDocument(text);
//        System.out.println(document.tokens());


//        //自定义功能
//        StanfordCoreNLP pipline = new StanfordCoreNLP(PropertiesUtils.asProperties("annotators", "tokenize,ssplit",
//                "ssplit.isOneSentence", "true",
//                "tokenize.language", "zh",
//                "segment.model", "edu/stanford/nlp/models/segmenter/chinese/ctb.gz",
//                "segment.sighanCorporaDict", "edu/stanford/nlp/models/segmenter/chinese",
//                "segment.serDictionary", "edu/stanford/nlp/models/segmenter/chinese/dict-chris6.ser.gz",
//                "segment.sighanPostProcessing", "true"));
//
//        //创建一个解析器，传入的是需要解析的文本
//        Annotation annotation = new Annotation("中华人民共和国");
//
//        //解析
//        pipline.annotate(annotation);
//
//        //根据标点符号，进行句子的切分，每一个句子被转化为一个CoreMap的数据结构，保存了句子的信息()
//        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
//
//        //从CoreMap 中取出CoreLabel List ,打印
//        for (CoreMap sentence : sentences) {
//            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
//                String word = token.get(CoreAnnotations.TextAnnotation.class);
//                System.out.println(word);
//            }
//        }

        // Create the Stanford CoreNLP pipeline
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,depparse,natlog,openie");
        props.setProperty("ssplit.isOneSentence", "true");
        props.setProperty("tokenize.language", "zh");
        props.setProperty("segment.model", "edu/stanford/nlp/models/segmenter/chinese/ctb.gz");
        props.setProperty("segment.sighanCorporaDict", "edu/stanford/nlp/models/segmenter/chinese");
        props.setProperty("segment.serDictionary", "edu/stanford/nlp/models/segmenter/chinese/dict-chris6.ser.gz");
        props.setProperty("segment.sighanPostProcessing", "true");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // Annotate an example document.
        Annotation doc = new Annotation("奥巴马出生在夏威夷");
        pipeline.annotate(doc);

        // Loop over sentences in the document
        for (CoreMap sentence : doc.get(CoreAnnotations.SentencesAnnotation.class)) {
            // Get the OpenIE triples for the sentence
            Collection<RelationTriple> triples =
                    sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
            // Print the triples
            for (RelationTriple triple : triples) {
                System.out.println(triple.confidence + "\t" +
                        triple.subjectLemmaGloss() + "\t" +
                        triple.relationLemmaGloss() + "\t" +
                        triple.objectLemmaGloss());
            }
        }
    }
}
