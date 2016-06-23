package org.thehellnet.utility.gaming.pb;

import static org.thehellnet.utility.gaming.pb.PBMD5Utility.encode;
import static org.thehellnet.utility.gaming.pb.PBMD5Utility.transform;

/**
 * Created by sardylan on 08/06/16.
 */
public class PBMD5 {

    private static final byte[] PADDING = {
            (byte) 0x80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    private PBMD5Context state;
    private PBMD5Context finals;

    public void init(long seed) {
        state = new PBMD5Context(seed);
        finals = null;
    }

    public void update(PBMD5Context context, byte buffer[], int offset, long length) {
        int index, partlen, i, start;

        finals = null;

        if ((length - offset) > buffer.length)
            length = buffer.length - offset;

        index = (int) (context.count[0] >>> 3) & 0x3f;

        if ((context.count[0] += (length << 3)) < (length << 3)) {
            context.count[1]++;
        }

        context.count[1] += length >>> 29;
        partlen = 64 - index;

        if (length >= partlen) {
            for (i = 0; i < partlen; i++) {
                context.buffer[i + index] = buffer[i + offset];
            }

            transform(context, context.buffer, 0);

            for (i = partlen; (i + 63) < length; i += 64) {
                transform(context, buffer, i);
            }

            index = 0;
        } else {
            i = 0;
        }

        if (i < length) {
            start = i;
            for (; i < length; i++) {
                context.buffer[index + i - start] = buffer[i + offset];
            }
        }
    }

    public void update(byte buffer[], int offset, long length) {
        update(this.state, buffer, offset, length);
    }

    public void update(byte buffer[], long length) {
        update(this.state, buffer, 0, length);
    }

    public void update(byte buffer[]) {
        update(buffer, 0, buffer.length);
    }

    public void update(byte b) {
        byte buffer[] = new byte[1];
        buffer[0] = b;
        update(buffer, 1);
    }

    public void update(String s) {
        byte[] chars = s.getBytes();
        update(chars, chars.length);
    }

    public void update(int i) {
        update((byte) (i & 0xff));
    }

    public byte[] finish() {
        byte bits[];
        int index, padlen;
        PBMD5Context fin;
        if (finals == null) {
            fin = new PBMD5Context(state);
            bits = encode(fin.count, 8);
            index = (int) ((fin.count[0] >>> 3) & 0x3f);
            padlen = (index < 56) ? (56 - index) : (120 - index);
            update(fin, PADDING, 0, padlen);
            update(fin, bits, 0, 8);
            finals = fin;
        }
        return encode(finals.state, 16);
    }
}
