package org.thehellnet.utility.gaming.pb;

/**
 * Created by sardylan on 09/06/16.
 */
class PBMD5Utility {

    static void transform(PBMD5Context state, byte buffer[], int shift) {
        long a = state.state[0];
        long b = state.state[1];
        long c = state.state[2];
        long d = state.state[3];
        long x[];

        x = decode(buffer, 64, shift);

        a = FF(a, b, c, d, x[0], 7, 0xd76aa478L); /* 1 */
        d = FF(d, a, b, c, x[1], 12, 0xe8c7b756L); /* 2 */
        c = FF(c, d, a, b, x[2], 17, 0x242070dbL); /* 3 */
        b = FF(b, c, d, a, x[3], 22, 0xc1bdceeeL); /* 4 */
        a = FF(a, b, c, d, x[4], 7, 0xf57c0fafL); /* 5 */
        d = FF(d, a, b, c, x[5], 12, 0x4787c62aL); /* 6 */
        c = FF(c, d, a, b, x[6], 17, 0xa8304613L); /* 7 */
        b = FF(b, c, d, a, x[7], 22, 0xfd469501L); /* 8 */
        a = FF(a, b, c, d, x[8], 7, 0x698098d8L); /* 9 */
        d = FF(d, a, b, c, x[9], 12, 0x8b44f7afL); /* 10 */
        c = FF(c, d, a, b, x[10], 17, 0xffff5bb1L); /* 11 */
        b = FF(b, c, d, a, x[11], 22, 0x895cd7beL); /* 12 */
        a = FF(a, b, c, d, x[12], 7, 0x6b901122L); /* 13 */
        d = FF(d, a, b, c, x[13], 12, 0xfd987193L); /* 14 */
        c = FF(c, d, a, b, x[14], 17, 0xa679438eL); /* 15 */
        b = FF(b, c, d, a, x[15], 22, 0x49b40821L); /* 16 */

        a = GG(a, b, c, d, x[1], 5, 0xf61e2562L); /* 17 */
        d = GG(d, a, b, c, x[6], 9, 0xc040b340L); /* 18 */
        c = GG(c, d, a, b, x[11], 14, 0x265e5a51L); /* 19 */
        b = GG(b, c, d, a, x[0], 20, 0xe9b6c7aaL); /* 20 */
        a = GG(a, b, c, d, x[5], 5, 0xd62f105dL); /* 21 */
        d = GG(d, a, b, c, x[10], 9, 0x2441453L); /* 22 */
        c = GG(c, d, a, b, x[15], 14, 0xd8a1e681L); /* 23 */
        b = GG(b, c, d, a, x[4], 20, 0xe7d3fbc8L); /* 24 */
        a = GG(a, b, c, d, x[9], 5, 0x21e1cde6L); /* 25 */
        d = GG(d, a, b, c, x[14], 9, 0xc33707d6L); /* 26 */
        c = GG(c, d, a, b, x[3], 14, 0xf4d50d87L); /* 27 */
        b = GG(b, c, d, a, x[8], 20, 0x455a14edL); /* 28 */
        a = GG(a, b, c, d, x[13], 5, 0xa9e3e905L); /* 29 */
        d = GG(d, a, b, c, x[2], 9, 0xfcefa3f8L); /* 30 */
        c = GG(c, d, a, b, x[7], 14, 0x676f02d9L); /* 31 */
        b = GG(b, c, d, a, x[12], 20, 0x8d2a4c8aL); /* 32 */

        a = HH(a, b, c, d, x[5], 4, 0xfffa3942L); /* 33 */
        d = HH(d, a, b, c, x[8], 11, 0x8771f681L); /* 34 */
        c = HH(c, d, a, b, x[11], 16, 0x6d9d6122L); /* 35 */
        b = HH(b, c, d, a, x[14], 23, 0xfde5380cL); /* 36 */
        a = HH(a, b, c, d, x[1], 4, 0xa4beea44L); /* 37 */
        d = HH(d, a, b, c, x[4], 11, 0x4bdecfa9L); /* 38 */
        c = HH(c, d, a, b, x[7], 16, 0xf6bb4b60L); /* 39 */
        b = HH(b, c, d, a, x[10], 23, 0xbebfbc70L); /* 40 */
        a = HH(a, b, c, d, x[13], 4, 0x289b7ec6L); /* 41 */
        d = HH(d, a, b, c, x[0], 11, 0xeaa127faL); /* 42 */
        c = HH(c, d, a, b, x[3], 16, 0xd4ef3085L); /* 43 */
        b = HH(b, c, d, a, x[6], 23, 0x4881d05L); /* 44 */
        a = HH(a, b, c, d, x[9], 4, 0xd9d4d039L); /* 45 */
        d = HH(d, a, b, c, x[12], 11, 0xe6db99e5L); /* 46 */
        c = HH(c, d, a, b, x[15], 16, 0x1fa27cf8L); /* 47 */
        b = HH(b, c, d, a, x[2], 23, 0xc4ac5665L); /* 48 */

        a = II(a, b, c, d, x[0], 6, 0xf4292244L); /* 49 */
        d = II(d, a, b, c, x[7], 10, 0x432aff97L); /* 50 */
        c = II(c, d, a, b, x[14], 15, 0xab9423a7L); /* 51 */
        b = II(b, c, d, a, x[5], 21, 0xfc93a039L); /* 52 */
        a = II(a, b, c, d, x[12], 6, 0x655b59c3L); /* 53 */
        d = II(d, a, b, c, x[3], 10, 0x8f0ccc92L); /* 54 */
        c = II(c, d, a, b, x[10], 15, 0xffeff47dL); /* 55 */
        b = II(b, c, d, a, x[1], 21, 0x85845dd1L); /* 56 */
        a = II(a, b, c, d, x[8], 6, 0x6fa87e4fL); /* 57 */
        d = II(d, a, b, c, x[15], 10, 0xfe2ce6e0L); /* 58 */
        c = II(c, d, a, b, x[6], 15, 0xa3014314L); /* 59 */
        b = II(b, c, d, a, x[13], 21, 0x4e0811a1L); /* 60 */
        a = II(a, b, c, d, x[4], 6, 0xf7537e82L); /* 61 */
        d = II(d, a, b, c, x[11], 10, 0xbd3af235L); /* 62 */
        c = II(c, d, a, b, x[2], 15, 0x2ad7d2bbL); /* 63 */
        b = II(b, c, d, a, x[9], 21, 0xeb86d391L); /* 64 */

        state.state[0] += a;
        state.state[1] += b;
        state.state[2] += c;
        state.state[3] += d;
    }

    static byte[] encode(long input[], int len) {
        byte out[] = new byte[len];
        for (int i = 0, j = 0; j < len; i++, j += 4) {
            out[j] = (byte) (input[i] & 0xff);
            out[j + 1] = (byte) ((input[i] >>> 8) & 0xff);
            out[j + 2] = (byte) ((input[i] >>> 16) & 0xff);
            out[j + 3] = (byte) ((input[i] >>> 24) & 0xff);
        }
        return out;
    }

    private static long ulong32(long n) {
        return n & 0xFFFFFFFFL;
    }

    private static long rotate_left(long x, long n) {
        return (x << n) | (x >>> (32 - n));
    }

    private static long uadd(long a, long b) {
        return a + b;
    }

    private static long uadd(long a, long b, long c) {
        return uadd(uadd(a, b), c);
    }

    private static long uadd(long a, long b, long c, long d) {
        return uadd(uadd(a, b, c), d);
    }

    private static long F(long b, long c, long d) {
        return (b & c) | (~b & d);
    }

    private static long G(long b, long c, long d) {
        return (b & d) | (c & ~d);
    }

    private static long H(long b, long c, long d) {
        return (b ^ c ^ d);
    }

    private static long I(long b, long c, long d) {
        return c ^ (b | ~d);
    }

    private static long FF(long a, long b, long c, long d, long x, long s, long ac) {
        a = uadd(a, F(b, c, d), x, ulong32(ac));
        return uadd(rotate_left(a, s), b);
    }

    private static long GG(long a, long b, long c, long d, long x, long s, long ac) {
        a = uadd(a, G(b, c, d), x, ulong32(ac));
        return uadd(rotate_left(a, s), b);
    }

    private static long HH(long a, long b, long c, long d, long x, long s, long ac) {
        a = uadd(a, H(b, c, d), x, ulong32(ac));
        return uadd(rotate_left(a, s), b);
    }

    private static long II(long a, long b, long c, long d, long x, long s, long ac) {
        a = uadd(a, I(b, c, d), x, ulong32(ac));
        return uadd(rotate_left(a, s), b);
    }

    private static long[] decode(byte buffer[], long len, int shift) {
        long[] out = new long[16];
        for (int i = 0, j = 0; j < len; i++, j += 4) {
            out[i] = buffer[j + shift] & 0xff |
                    ((buffer[j + 1 + shift] & 0xff) << 8) |
                    ((buffer[j + 2 + shift] & 0xff) << 16) |
                    ((buffer[j + 3 + shift] & 0xff) << 24);
        }
        return out;
    }
}
