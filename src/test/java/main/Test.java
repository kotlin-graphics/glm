package main;

import vec._2.Vec2;
import vec._2.Vec2i;

import static main.GlmKt.glm;

/**
 * Created by GBarbieri on 08.02.2017.
 */
public class Test {

//    final static Glm glm = Glm.INSTANCE;

//    private static glm glm = main.glm.INSTANCE;

    public static void main(String[] argvs) {
        glm.normalize(3.4);
        glm.detail.mod289(new Vec2());

        Vec2i v = new Vec2i(3, 4);
    }
}
