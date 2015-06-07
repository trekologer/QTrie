/*
 * Copyright (c) 2014-2015. Andrew D. Bucko <adb@trekologer.net>
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.trekologer.qtrie;

import org.junit.Test;

import static org.junit.Assert.*;

public class QTrieTest {
    /**
     * Test basic object creation.
     */
    @Test
    public void testQTrie() {
        QTrie trie = null;

        try {
            trie = new QTrie();
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception Occurred: "+e.getMessage());
        }

        assertNotNull(trie);
        assertTrue(trie.getClass().getName().equals("net.trekologer.qtrie.QTrie"));
    }

    @Test
    public void testAdd() {
        String pattern = "blah";

        QTrie trie = null;

        try {
            trie = new QTrie();
            trie.add(pattern);
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception Occurred: "+e.getMessage());
        }

        assertNotNull(trie);
        assertEquals(pattern, trie.searchExact(pattern));
        assertNull(trie.searchExact(pattern + "yadda"));
        assertEquals(pattern, trie.searchPrefix(pattern+"yadda"));
    }

    @Test
    public void testAddMultiple() {
        String pattern0 = "blah";
        String pattern1 = "foo";
        String pattern2 = "bar";

        QTrie trie = null;

        try {
            trie = new QTrie();
            trie.add(pattern0);
            trie.add(pattern1);
            trie.add(pattern2);
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception Occurred: "+e.getMessage());
        }

        assertNotNull(trie == null);
        assertEquals(pattern0, trie.searchExact(pattern0));
        assertNull(trie.searchExact(pattern0 + "yadda"));
        assertEquals(pattern0, trie.searchPrefix(pattern0));
        assertEquals(pattern1, trie.searchExact(pattern1));
        assertNull(trie.searchExact(pattern1 + "yadda"));
        assertEquals(pattern1, trie.searchPrefix(pattern1));
        assertEquals(pattern2, trie.searchExact(pattern2));
        assertNull(trie.searchExact(pattern2 + "yadda"));
        assertEquals(pattern2, trie.searchPrefix(pattern2));
    }

    @Test
    public void testAddNull() {
        QTrie trie = null;
        boolean exceptionOccurred = false;

        try {
            trie = new QTrie();
            trie.add(null);
        } catch(IllegalArgumentException e) {
            exceptionOccurred = true;
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception Occurred: "+e.getMessage());
        }

        assertFalse(trie == null);
        assertTrue(exceptionOccurred);
    }

}