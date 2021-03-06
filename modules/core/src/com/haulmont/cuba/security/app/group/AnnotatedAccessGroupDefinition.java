/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.cuba.security.app.group;

import com.haulmont.cuba.security.group.AccessGroupDefinition;
import com.haulmont.cuba.security.group.ConstraintsContainer;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

public abstract class AnnotatedAccessGroupDefinition implements AccessGroupDefinition {
    @Inject
    protected AnnotatedGroupDefinitionBuilder annotatedGroupDefinitionBuilder;

    @Override
    public String getName() {
        return annotatedGroupDefinitionBuilder.getNameFromAnnotation(this);
    }

    @Override
    public String getParent() {
        return annotatedGroupDefinitionBuilder.getParentFromAnnotation(this);
    }

    @Override
    public ConstraintsContainer accessConstraints() {
        return annotatedGroupDefinitionBuilder.buildSetOfAccessConstraints(this);
    }

    @Override
    public Map<String, Serializable> sessionAttributes() {
        return annotatedGroupDefinitionBuilder.buildSessionAttributes(this);
    }
}
