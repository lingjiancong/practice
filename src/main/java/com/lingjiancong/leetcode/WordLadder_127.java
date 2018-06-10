package com.lingjiancong.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lingjiancong
 */
public class WordLadder_127 {

    private int minLen = Integer.MAX_VALUE;

    private int successTime = 0;

    private Set<String> impossibleWord = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList != null && !wordList.contains(endWord)) {
            return 0;
        }
        List<String> process = new ArrayList<>();
        ladderLength(beginWord, endWord, wordList, process);

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }

    public void ladderLength(String beginWord, String endWord, List<String> wordList, List<String> process) {

        final int charStart = 'a', charEnd = 'z', charSize = 26;

        int len = beginWord.length();

        if (impossibleWord.contains(beginWord)) {
            return;
        }

        if (differOnce(beginWord, endWord)) {
            if (process.size() + 2 < minLen) {
                minLen = process.size() + 2;
                print(process);
            }
            successTime++;
            return;
        }

        int beforeSuccessTime = successTime;

        for (int i = 0; i < len; ++i) {
            for (int j = 1; j < charSize; ++j) {

                // get adjacent word
                char[] chars = new char[len];
                char c = (char) ((beginWord.charAt(i) + j - charStart) % 26 + charStart);
                beginWord.getChars(0, len, chars, 0);
                chars[i] = c;
                String adjWord = new String(chars);

                if (wordList.contains(adjWord) && !process.contains(adjWord)) {
                    process.add(beginWord);
//                    if (process.size() + 1 > minLen) {
//                        process.remove(process.size() - 1);
//                        return;
//                    } else
                    if (adjWord.equals(endWord)) {
                        if (minLen > process.size() + 1) {
                            minLen = process.size() + 1;
                            print(process);
                        }
                        successTime++;
                    } else {
                        ladderLength(adjWord, endWord, wordList, process);
                    }
                    process.remove(process.size() - 1);
                } else if (wordList.contains(adjWord)) {
                    successTime++;
                }
            }
        }

        if (successTime == beforeSuccessTime) {
            impossibleWord.add(beginWord);
        }

    }

    public Boolean differOnce(String w1, String w2) {
        if (w1 == null || w2 == null) {
            return false;
        }
        if (w1.length() != w2.length()) {
            return false;
        }
        int diffNum = 0;
        for (int i = 0; i < w1.length(); ++i) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diffNum++;
            }
            if (diffNum > 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String beginWord = "cet", endWord = "ism";
        List<String> wordList = Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob");
        WordLadder_127 wordLadder = new WordLadder_127();

        int min = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println(min);
    }

    @Test
    public void testCharacter() {

        String word = "ab";
        int charStart = 'a', charEnd = 'z';

        int len = word.length();
        for (int i = 0; i < len; ++i) {
            for (int j = 1; j < 26; ++j) {
                char[] chars = new char[len];
                char c = (char) ((word.charAt(i) + j - charStart) % 26 + charStart);
                word.getChars(0, len, chars, 0);
                chars[i] = c;
                System.out.println(new String(chars));
            }
        }

    }

    public void print(List<String> list) {
        for (String s : list) {
            System.out.println(" " + s);
        }
        System.out.println();
    }
}
