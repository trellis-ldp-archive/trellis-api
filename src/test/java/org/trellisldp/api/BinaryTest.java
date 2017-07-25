/*
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
package org.trellisldp.api;

import static java.time.Instant.parse;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;

import java.time.Instant;

import org.apache.commons.rdf.api.IRI;
import org.apache.commons.rdf.api.RDF;
import org.apache.commons.rdf.simple.SimpleRDF;
import org.junit.Test;

/**
 * @author acoburn
 */
public class BinaryTest {

    private final static RDF rdf = new SimpleRDF();

    private final Long size = 10L;
    private final String mimeType = "text/plain";
    private final Instant modified = parse("2015-09-15T06:14:00.00Z");
    private final IRI identifier = rdf.createIRI("trellis:repository/resource");

    @Test
    public void testBinary() {
        final Binary binary = new Binary(identifier, modified, mimeType, size);
        assertEquals(identifier, binary.getIdentifier());
        assertEquals(of(mimeType), binary.getMimeType());
        assertEquals(of(size), binary.getSize());
        assertEquals(modified, binary.getModified());
    }

    @Test
    public void testBinaryWithOptionalArgs() {
        final Binary binary = new Binary(identifier, modified, null, null);
        assertEquals(identifier, binary.getIdentifier());
        assertEquals(empty(), binary.getMimeType());
        assertEquals(empty(), binary.getSize());
        assertEquals(modified, binary.getModified());
    }

}
