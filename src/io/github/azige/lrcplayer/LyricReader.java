/*
 * Copyright 2014 Azige.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.azige.lrcplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import io.github.azige.lrcplayer.Lyric.LyricMetaType;

/**
 *
 * @author Azige
 */
public class LyricReader{

    private static final Logger LOG = Logger.getLogger(LyricReader.class.getName());
    private static final Map<LyricMetaType, Pattern> metaInfoPatterns = new HashMap<>();
    private static final Pattern lyricEventPattern = Pattern.compile("\\[\\d\\d:\\d\\d\\.\\d\\d\\].*");
    private final BufferedReader in;

    static{
        Arrays.asList(Lyric.LyricMetaType.values()).forEach(it -> {
            metaInfoPatterns.put(it, Pattern.compile("\\[" + it.getTag() + ":.+\\]"));
        });
    }

    public LyricReader(Reader in){
        if (in instanceof BufferedReader){
            this.in = (BufferedReader)in;
        }else{
            this.in = new BufferedReader(in);
        }
    }

    public Lyric readLyric() throws IOException{
        Lyric lrc = new Lyric();
        while (true){
            String line = in.readLine();
            if (line == null){
                break;
            }

            final String tLine = line.trim();
            metaInfoPatterns.entrySet().forEach(e -> {
                if (e.getValue().matcher(tLine).matches()){
                    Scanner scanner = new Scanner(tLine);
                    String info = scanner.skip("\\[.*:").useDelimiter("\\]").next();
                    lrc.setMeta(e.getKey(), info);
                }
            });
            if (lyricEventPattern.matcher(tLine).matches()){
                Scanner scanner = new Scanner(tLine).useDelimiter("");
                String timeStamp = scanner.skip("\\[").useDelimiter("\\]").next();
                String word = scanner.skip("\\]").hasNext() ? scanner.nextLine() : "";
                lrc.getEvents().add(new LyricEvent(LyricTimeStamp.parse(timeStamp), word));
            }
        }
        return lrc;
    }

    public void close() throws IOException{
        in.close();
    }
}
