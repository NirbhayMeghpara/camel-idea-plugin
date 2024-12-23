/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.cameltooling.idea.language;

import com.intellij.lang.Language;

import java.util.Arrays;
import java.util.List;

public final class CamelLanguages {
    public static final DatasonnetLanguage DATASONNET_LANGUAGE = DatasonnetLanguage.getInstance();
    public static final SimpleLanguage SIMPLE_LANGUAGE = SimpleLanguage.getInstance();
    public static final ConstantLanguage CONSTANT_LANGUAGE = ConstantLanguage.getInstance();

    public static final List<Language> ALL = Arrays.asList(
            DATASONNET_LANGUAGE,
            SIMPLE_LANGUAGE,
            CONSTANT_LANGUAGE
    );

    private CamelLanguages() {

    }

}
