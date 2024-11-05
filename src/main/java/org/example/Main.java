package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // 五十音图平假名数组
    private static final String[] HIRAGANA = {
            "あ", "い", "う", "え", "お",
            "か", "き", "く", "け", "こ",
            "さ", "し", "す", "せ", "そ",
            "た", "ち", "つ", "て", "と",
            "な", "に", "ぬ", "ね", "の",
            "は", "ひ", "ふ", "へ", "ほ",
            "ま", "み", "む", "め", "も",
            "や", "ゆ", "よ",
            "ら", "り", "る", "れ", "ろ",
            "わ", "を", "ん"
    };

    // 五十音片假名数组
    private static final String[] KATAKANA = {
            "ア", "イ", "ウ", "エ", "オ",
            "カ", "キ", "ク", "ケ", "コ",
            "サ", "シ", "ス", "セ", "ソ",
            "タ", "チ", "ツ", "テ", "ト",
            "ナ", "ニ", "ヌ", "ネ", "ノ",
            "ハ", "ヒ", "フ", "ヘ", "ホ",
            "マ", "ミ", "ム", "メ", "モ",
            "ヤ", "ユ", "ヨ",
            "ラ", "リ", "ル", "レ", "ロ",
            "ワ", "ヲ", "ン"
    };

    // 对应的罗马音数组
    private static final String[] ROMAJI = {
            "a", "i", "u", "e", "o",
            "ka", "ki", "ku", "ke", "ko",
            "sa", "shi", "su", "se", "so",
            "ta", "chi", "tsu", "te", "to",
            "na", "ni", "nu", "ne", "no",
            "ha", "hi", "fu", "he", "ho",
            "ma", "mi", "mu", "me", "mo",
            "ya", "yu", "yo",
            "ra", "ri", "ru", "re", "ro",
            "wa", "wo", "n"
    };

    // 对应的汉字数组（假设每个假名对应的汉字）
    private static final String[] KANJI = {
            "安", "伊", "宇", "衣", "於",
            "加", "幾", "久", "計", "己",
            "左", "之", "寸", "世", "曽",
            "多", "知", "川", "天", "止",
            "奈", "仁", "奴", "祢", "乃",
            "波", "比", "不", "部", "保",
            "末", "美", "武", "女", "毛",
            "也", "由", "与",
            "良", "利", "留", "礼", "呂",
            "和", "遠", "無"
    };

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int count = 3;  // 选择的假名个数
        int totalCount = 25;

        while (true) {
            // 创建存储随机选择的假名和对应罗马音的数组
            String[] selectedHiragana = new String[count];
            String[] selectedKatakana = new String[count];
            String[] correctRomaji = new String[count];
            String[] selectedKanji = new String[count];

            // 随机选择 count 个假名
            for (int i = 0; i < count; i++) {
                int index = random.nextInt(totalCount);
                selectedHiragana[i] = HIRAGANA[index];
                selectedKatakana[i] = KATAKANA[index];
                correctRomaji[i] = ROMAJI[index];
                selectedKanji[i] = KANJI[index];
            }

            // 显示平假名和片假名
            System.out.println("平假名: ");
            for (String hiragana : selectedHiragana) {
                System.out.print(hiragana + " ");
            }
            System.out.println();

            System.out.println("片假名: ");
            for (String katakana : selectedKatakana) {
                System.out.print(katakana + " ");
            }
            System.out.println();

            // 提示用户输入对应的罗马音，并用空格分隔
            System.out.print("请输入对应的罗马音 (用空格分隔): ");
            String[] userInputs = scanner.nextLine().trim().toLowerCase().split("\\s+");

            // 检查输入的数量是否正确
            if (userInputs.length != count) {
                System.out.println("输入的数量不正确，请输入 " + count + " 个罗马音。");
                continue;
            }

            // 比对用户输入和正确答案
            int correctCount = 0;
            for (int i = 0; i < count; i++) {
                if (userInputs[i].equals(correctRomaji[i])) {
                    System.out.println("平假名 " + selectedHiragana[i] + ",片假名 " + selectedKatakana[i] + ": 正确！");
                    correctCount++;
                } else {
                    System.out.println("平假名 " + selectedHiragana[i] + ",片假名 " + selectedKatakana[i] + ": 错误！正确的罗马音是: " + correctRomaji[i]);
                }

                // 输出对应的汉字
                System.out.println("对应的汉字是: " + selectedKanji[i]);
            }

            System.out.println("你答对了 " + correctCount + " / " + count + " 个假名。");
            System.out.println();
        }
    }
}
