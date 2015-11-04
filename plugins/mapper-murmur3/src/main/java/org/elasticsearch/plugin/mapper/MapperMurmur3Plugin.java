/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.plugin.mapper;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.IndexService;
import org.elasticsearch.index.mapper.murmur3.Murmur3FieldMapper;
import org.elasticsearch.plugins.Plugin;

import java.io.Closeable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MapperMurmur3Plugin extends Plugin {

    @Override
    public String name() {
        return "mapper-murmur3";
    }

    @Override
    public String description() {
        return "A mapper that allows to precompute murmur3 hashes of values at index-time and store them in the index";
    }

    @Override
    public List<Closeable> indexService(IndexService indexService) {
        indexService.mapperService().documentMapperParser().putTypeParser(Murmur3FieldMapper.CONTENT_TYPE, new Murmur3FieldMapper.TypeParser());
        return super.indexService(indexService);
    }

}
