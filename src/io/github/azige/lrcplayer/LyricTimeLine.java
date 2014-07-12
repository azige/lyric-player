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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Azige
 */
public class LyricTimeLine{

    private long time = 0;
    private int currentEventIndex = 0;
    private final List<LyricEvent> events;

    public LyricTimeLine(Lyric lrc){
        List<LyricEvent> list = new LinkedList<>(lrc.getEvents());
        list.add(0, new LyricEvent(LyricTimeStamp.fromMillis(0), ""));
        this.events = Collections.unmodifiableList(list);
    }

    public long getTime(){
        return time;
    }

    public void setTime(long time){
        this.time = time;
        LyricEvent currentEvent = events.get(currentEventIndex);
        if (currentEvent.getTimeStamp().getMillis() < time){
            while (currentEventIndex < events.size() - 1
                && events.get(currentEventIndex + 1).getTimeStamp().getMillis() < time){
                currentEventIndex++;
            }
        }else if (currentEventIndex > 0 && events.get(currentEventIndex - 1).getTimeStamp().getMillis() > time){
            while (currentEventIndex > 0
                && events.get(--currentEventIndex).getTimeStamp().getMillis() > time){
                // do nothing
            }
        }
    }

    public int getCurrentEventIndex(){
        return currentEventIndex;
    }

    public LyricEvent getCurrentEvent(){
        return events.get(currentEventIndex);
    }

    public List<LyricEvent> getEvents(){
        return events;
    }
}
