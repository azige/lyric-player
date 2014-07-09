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

import java.io.PrintWriter;
import java.io.Writer;

/**
 *
 * @author Azige
 */
public class LyricWriter{

    private final PrintWriter out;

    public LyricWriter(Writer out){
        if (out instanceof PrintWriter){
            this.out = (PrintWriter)out;
        }else{
            this.out = new PrintWriter(out);
        }
    }

    public void writeLyric(Lyric lyric){
        lyric.metaInfoMap.entrySet().forEach(e -> {
            out.printf("[%s:%s]", e.getKey().getTag(), e.getValue())
                .println();
        });
        lyric.getEvents().forEach(e -> {
            out.printf("[%s]", e.getTimeStamp())
                .println(e.getLyric());
        });
    }

    public void flush(){
        out.flush();
    }

    public void close(){
        out.close();
    }
}
