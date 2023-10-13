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
package com.github.cameltooling.idea.completion;

import java.util.Arrays;
import java.util.List;

import com.github.cameltooling.idea.CamelLightCodeInsightFixtureTestCaseIT;

/**
 * Testing basic completion with Kamelet name in a Camel Kamelet binding.
 */
public class CamelKameletNameCompletionIT extends CamelLightCodeInsightFixtureTestCaseIT {

    @Override
    protected String getTestDataPath() {
        return "src/test/resources/testData/completion/kamelet/name";
    }

    public void testBindingNoKamelet() {
        myFixture.configureByFiles("binding-no-kamelet.yaml");
        myFixture.completeBasic();
        List<String> strings = myFixture.getLookupElementStrings();
        assertNotNull(strings);
        assertTrue(strings.isEmpty());
    }

    public void testBindingNoName() {
        myFixture.configureByFiles("binding-no-name.yaml");
        myFixture.completeBasic();
        List<String> strings = myFixture.getLookupElementStrings();
        assertNotNull(strings);
        assertTrue(strings.isEmpty());
    }

    public void testBindingUnknown() {
        myFixture.configureByFiles("binding-unknown.yaml");
        myFixture.completeBasic();
        List<String> strings = myFixture.getLookupElementStrings();
        assertNotNull(strings);
        assertTrue(strings.isEmpty());
    }

    public void testBindingBySource() {
        myFixture.configureByFiles("binding-source.yaml");
        myFixture.completeBasic();
        List<String> strings = myFixture.getLookupElementStrings();
        assertNotNull(strings);
        assertTrue(strings.containsAll(Arrays.asList("timer-source", "aws-s3-source")));
        assertFalse(strings.containsAll(Arrays.asList("log-sink", "avro-deserialize-action")));
        myFixture.type("ti");
        strings = myFixture.getLookupElementStrings();
        assertNotNull(strings);
        assertTrue(strings.contains("timer-source"));
        assertFalse(strings.containsAll(Arrays.asList("log-sink", "avro-deserialize-action", "aws-s3-source")));
    }

    public void testBindingBySink() {
        myFixture.configureByFiles("binding-sink.yaml");
        myFixture.completeBasic();
        List<String> strings = myFixture.getLookupElementStrings();
        assertNotNull(strings);
        assertTrue(strings.containsAll(Arrays.asList("log-sink", "avro-deserialize-action")));
        assertFalse(strings.containsAll(Arrays.asList("timer-source", "aws-s3-source")));
        myFixture.type("av");
        strings = myFixture.getLookupElementStrings();
        assertNotNull(strings);
        assertTrue(strings.contains("avro-deserialize-action"));
        assertFalse(strings.containsAll(Arrays.asList("log-sink", "timer-source", "aws-s3-source")));
    }

    public void testBindingBySteps() {
        myFixture.configureByFiles("binding-steps.yaml");
        myFixture.completeBasic();
        List<String> strings = myFixture.getLookupElementStrings();
        assertNotNull(strings);
        assertTrue(strings.containsAll(Arrays.asList("log-sink", "avro-deserialize-action")));
        assertFalse(strings.containsAll(Arrays.asList("timer-source", "aws-s3-source")));
        myFixture.type("av");
        strings = myFixture.getLookupElementStrings();
        assertNotNull(strings);
        assertTrue(strings.contains("avro-deserialize-action"));
        assertFalse(strings.containsAll(Arrays.asList("log-sink", "timer-source", "aws-s3-source")));
    }

    public void testBinding() {
        myFixture.configureByFiles("binding.yaml");
        myFixture.completeBasic();
        myFixture.type('\n');
        myFixture.checkResultByFile("bindingResult.yaml");
    }
}
