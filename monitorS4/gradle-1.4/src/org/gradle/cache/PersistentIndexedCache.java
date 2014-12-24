/*
 * Copyright 2009 the original author or authors.
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
package org.gradle.cache;

/**
 * A persistent store of objects of type V indexed by a key of type K.
 */
public interface PersistentIndexedCache<K, V> {
    /**
     * Fetches the value of a key from this cache. A shared or exclusive lock is held while fetching the value, depending on implementation.
     *
     * @return The value, or null if no value associated with the key.
     */
    V get(K key);

    /**
     * Puts/replaces the value of a key in this cache. A shared lock is held while updating the value.
     */
    void put(K key, V value);

    /**
     * Removes a key-value mapping from this cache. A shared lock is held while updating the value.
     */
    void remove(K key);
}
