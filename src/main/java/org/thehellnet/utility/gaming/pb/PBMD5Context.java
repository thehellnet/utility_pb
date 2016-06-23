package org.thehellnet.utility.gaming.pb;

/**
 * Created by sardylan on 08/06/16.
 */
class PBMD5Context {

    long state[] = new long[4];
    long count[] = new long[2];
    byte buffer[] = new byte[64];

    PBMD5Context(long seed) {
        state[0] = 0x67452301L + seed * 11;
        state[1] = 0xefcdab89L + seed * 71;
        state[2] = 0x98badcfeL + seed * 37;
        state[3] = 0x10325476L + seed * 97;

        count[0] = 0;
        count[1] = 0;
    }

    PBMD5Context(PBMD5Context from) {
        System.arraycopy(from.buffer, 0, this.buffer, 0, buffer.length);
        System.arraycopy(from.state, 0, this.state, 0, state.length);
        System.arraycopy(from.count, 0, this.count, 0, count.length);
    }
}
