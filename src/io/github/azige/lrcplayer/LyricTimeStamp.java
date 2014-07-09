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

import java.util.Scanner;

/**
 *
 * @author Azige
 */
public class LyricTimeStamp implements Comparable<LyricTimeStamp>{

    private final long millis;
    private final String string;

    LyricTimeStamp(long millis, String string){
        this.millis = millis;
        this.string = string;
    }

    public static LyricTimeStamp parse(String timeStamp){
        Scanner scanner = new Scanner(timeStamp);
        int mm = Integer.parseInt(scanner.useDelimiter(":").next());
        int ss = Integer.parseInt(scanner.skip(":").useDelimiter("\\.").next());
        int SS = Integer.parseInt(scanner.skip("\\.").nextLine());
        return new LyricTimeStamp(mm * 60 * 1000 + ss * 1000 + SS * 10, timeStamp);
    }

    public static LyricTimeStamp fromMillis(long millis){
        long t = millis;
        t /= 10;
        long SS = t % 100;
        t /= 100;
        long ss = t % 60;
        t /= 60;
        long mm = t;
        return new LyricTimeStamp(millis, String.format("%02d:%02d.%02d", mm, ss, SS));
    }

    public long getMillis(){
        return millis;
    }

    @Override
    public String toString(){
        return string;
    }

    @Override
    public int compareTo(LyricTimeStamp o){
        return (int)Math.signum(this.millis - o.millis);
    }
}
