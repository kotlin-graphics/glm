package glm_;

import glm_.Java.Glm;
import glm_.mat4x4.Mat4;
import glm_.vec2.Vec2;
import glm_.vec3.Vec3;

//import static glm.Java.glm;

/**
 * Created by GBarbieri on 08.02.2017.
 */
public class Test {

    final static Glm glm = Glm.INSTANCE;

    public static void main(String[] argvs) {
        glm.normalize(3.4);
        Glm.detail.mod289(new Vec2());

        Vec2 v = new Vec2(3, 4);

        Vec2 a = (Vec2) v.xx();
        a.xy(v.xy());
//        Vec2 b = (Vec2) v.aa();
    }


    public Mat4 transform(Vec2 orientation, Vec3 translate, Vec3 up) {
        Mat4 proj = glm.perspective(glm.radians(45f), 1.33f, 0.1f, 10f);
        Mat4 viewTranslate = glm.translate(new Mat4(1f), translate);
        Mat4 viewRotateX = glm.rotate(viewTranslate, orientation.y, up);
        Mat4 view = glm.rotate(viewRotateX, orientation.x, up);
        Mat4 model = new Mat4(1f);
        return proj.times(view).times(model);
    }
}
