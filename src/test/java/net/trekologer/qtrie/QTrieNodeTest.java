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

public class QTrieNodeTest {
    @Test
    public void testQTrieNode() {
        QTrieNode node = null;

        try {
            node = new QTrieNode();
        } catch(Exception e) {
            fail("Exception Occurred: "+e.getMessage());
        }

        assertFalse(node == null);
    }
}