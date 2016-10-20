/*
 *  * Copyright 2016 Skymind, Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 */

package org.datavec.spark.transform.utils;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Factory to create spark connections
 */
@Deprecated
public class SparkConnectFactory {

    public static String name = "SparkConnectFactory";

    public static SparkConf config() {
        return config(name);
    }

    public static SparkConf config(String name){
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local[*]");
        sparkConf.set("spark.driver.maxResultSize", "2G");
        sparkConf.setAppName(name);
        return sparkConf;
    }

    public static JavaSparkContext getContext(){
        return getContext(name);
    }

    public static JavaSparkContext getContext(String name){
        return new JavaSparkContext(config(name));
    }

}