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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Azige
 */
public class Lyric{

    public enum LyricMetaType{

        ALBUM("al"), ARTIST("ar"), BY("by"), OFFSET("offset"),
        EDITOR("re"), TITLE("ti"), VERSION("ve");
        private final String tag;

        private LyricMetaType(String tag){
            this.tag = tag;
        }

        public String getTag(){
            return tag;
        }
    }

    final Map<LyricMetaType, String> metaInfoMap = new LinkedHashMap<>();
    private final SortedSet<LyricEvent> events = new TreeSet<>();

    public String getMeta(LyricMetaType key){
        return metaInfoMap.get(key);
    }

    public void setMeta(LyricMetaType key, String value){
        if (value == null){
            metaInfoMap.remove(key);
        }else{
            metaInfoMap.put(key, value);
        }
    }

    public SortedSet<LyricEvent> getEvents(){
        return events;
    }
}
