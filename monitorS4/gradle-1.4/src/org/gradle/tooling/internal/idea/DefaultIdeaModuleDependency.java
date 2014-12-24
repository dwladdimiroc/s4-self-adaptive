/*
 * Copyright 2011 the original author or authors.
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

package org.gradle.tooling.internal.idea;

import org.gradle.tooling.model.idea.IdeaDependencyScope;
import org.gradle.tooling.model.idea.IdeaModule;
import org.gradle.tooling.model.idea.IdeaModuleDependency;

import java.io.Serializable;

/**
 * @author: Szczepan Faber, created at: 7/26/11
 */
public class DefaultIdeaModuleDependency implements IdeaModuleDependency, Serializable {

    private IdeaDependencyScope scope;
    private IdeaModule dependencyModule;
    private boolean exported;

    public IdeaDependencyScope getScope() {
        return scope;
    }

    public DefaultIdeaModuleDependency setScope(IdeaDependencyScope scope) {
        this.scope = scope;
        return this;
    }

    public IdeaModule getDependencyModule() {
        return dependencyModule;
    }

    public DefaultIdeaModuleDependency setDependencyModule(IdeaModule dependencyModule) {
        this.dependencyModule = dependencyModule;
        return this;
    }

    public boolean getExported() {
        return exported;
    }

    public DefaultIdeaModuleDependency setExported(boolean exported) {
        this.exported = exported;
        return this;
    }

    @Override
    public String toString() {
        return "DefaultIdeaModuleDependency{"
                 + "scope='" + scope + '\''
                 + ", dependencyModule name='" + dependencyModule.getName() + '\''
                 + ", exported=" + exported
                 + '}';
    }
}