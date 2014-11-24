/*
 * Joinery -- Data frames for Java
 * Copyright (c) 2014, 2015 IBM Corp.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package joinery.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class Index {
    private final Map<String, Integer> index;

    public Index() {
        this(Collections.<String>emptyList());
    }

    public Index(final Collection<String> names) {
        this(names, names.size());
    }

    public Index(final Collection<String> names, final int size) {
        index = new LinkedHashMap<>(names.size());
        final Iterator<String> it = names.iterator();
        for (int i = 0; i < size; i++) {
            final String name = it.hasNext() ? it.next() : String.valueOf(i);
            add(name, i);
        }
    }

    public void add(final String name, final Integer value) {
        if (index.put(name, value) != null) {
            throw new IllegalArgumentException("duplicate name " + name +  " in index");
        }
    }

    public void set(final String name, final Integer value) {
        index.put(name, value);
    }

    public Integer get(final String name) {
        return index.get(name);
    }

    public Set<String> names() {
        return index.keySet();
    }
}
