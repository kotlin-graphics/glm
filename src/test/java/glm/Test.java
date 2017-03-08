package glm;

import quat.Quat;
import vec._2.Vec2;

import static glm.GlmKt.glm;

/**
 * Created by GBarbieri on 08.02.2017.
 */
public class Test {

//    final static Glm glm = Glm.INSTANCE;

//    private static glm glm = main.glm.INSTANCE;

    public static void main(String[] argvs) {
        glm.normalize(3.4);
        glm.detail.mod289(new Vec2());

        Vec2 v = new Vec2(3, 4);

        Quat quat = new Quat();

        v.x = 3f;
        float x = v.x;
    }
}
