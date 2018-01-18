package glm_

import glm_.glm.epsilonF
import glm_.vec2.Vec2
import glm_.vec3.Vec3

/// @ref gtx_intersect
/// @file glm/gtx/intersect.hpp
///
/// @see core (dependence)
/// @see gtx_closest_point (dependence)
///
/// @defgroup gtx_intersect GLM_GTX_intersect
/// @ingroup gtx
///
/// Include <glm/gtx/intersect.hpp> to use the features of this extension.
///
/// Add intersection functions

interface gtxIntersect {

    /** Compute the intersection of a ray and a plane.
     *  Ray direction and plane normal must be unit length.
     *  From GLM_GTX_intersect extension. */
//    fun intersectRayPlane(
//    genType const & orig, genType const & dir,
//    genType const & planeOrig, genType const & planeNormal,
//    typename genType::value_type & intersectionDistance);

    /** Compute the intersection of a ray and a triangle.
     *  Based om Tomas Möller implementation http://fileadmin.cs.lth.se/cs/Personal/Tomas_Akenine-Moller/raytri/
     *  @return Boolean to Distance, if false, distance is invalid (-1f)  */
    fun intersectRayTriangle(orig: Vec3, dir: Vec3, vert0: Vec3, vert1: Vec3, vert2: Vec3, baryPosition: Vec2): Pair<Boolean, Float> {
        // find vectors for two edges sharing vert0
        val edge1 = vert1 - vert0
        val edge2 = vert2 - vert0

        // begin calculating determinant - also used to calculate U parameter
        val p = dir cross edge2

        // if determinant is near zero, ray lies in plane of triangle
        val det = edge1 dot p

        val qVec: Vec3

        when {
            det > epsilonF -> {
                // calculate distance from vert0 to ray origin
                val tVec = orig - vert0

                // calculate U parameter and test bounds
                baryPosition.x = tVec dot p
                if (baryPosition.x < 0 || baryPosition.x > det)
                    return false to -1f

                // prepare to test V parameter
                qVec = tVec cross edge1

                // calculate V parameter and test bounds
                baryPosition.y = dir dot qVec
                if (baryPosition.y < 0 || (baryPosition.x + baryPosition.y) > det)
                    return false to -1f
            }
            det < -epsilonF -> {
                // calculate distance from vert0 to ray origin
                val tVec = orig- vert0

                // calculate U parameter and test bounds
                baryPosition.x = tVec dot p
                if (baryPosition.x > 0 || baryPosition.x < det)
                    return false to -1f

                // prepare to test V parameter
                qVec = tVec cross edge1

                // calculate V parameter and test bounds
                baryPosition.y = dir dot qVec
                if (baryPosition.y > 0 || baryPosition.x + baryPosition.y < det)
                    return false to -1f
            }
            else -> return false to -1f // ray is parallel to the plane of the triangle
        }

        val invDet = 1 / det

        // calculate distance, ray intersects triangle
        val distance = (edge2 dot qVec) * invDet
        baryPosition *= invDet

        return true to distance
    }

    //! Compute the intersection of a line and a triangle.
    //! From GLM_GTX_intersect extension.
//    template<typename genType>
//    GLM_FUNC_DECL bool intersectLineTriangle(
//    genType const & orig, genType const & dir,
//    genType const & vert0, genType const & vert1, genType const & vert2,
//    genType & position)
//
//    //! Compute the intersection distance of a ray and a sphere.
//    //! The ray direction vector is unit length.
//    //! From GLM_GTX_intersect extension.
//    template<typename genType>
//    GLM_FUNC_DECL bool intersectRaySphere(
//    genType const & rayStarting, genType const & rayNormalizedDirection,
//    genType const & sphereCenter, typename genType::value_type const sphereRadiusSquered,
//    typename genType::value_type & intersectionDistance)
//
//    //! Compute the intersection of a ray and a sphere.
//    //! From GLM_GTX_intersect extension.
//    template<typename genType>
//    GLM_FUNC_DECL bool intersectRaySphere(
//    genType const & rayStarting, genType const & rayNormalizedDirection,
//    genType const & sphereCenter, const typename genType::value_type sphereRadius,
//    genType & intersectionPosition, genType & intersectionNormal)
//
//    //! Compute the intersection of a line and a sphere.
//    //! From GLM_GTX_intersect extension
//    template<typename genType>
//    GLM_FUNC_DECL bool intersectLineSphere(
//    genType const & point0, genType const & point1,
//    genType const & sphereCenter, typename genType::value_type sphereRadius,
//    genType & intersectionPosition1, genType & intersectionNormal1,
//    genType & intersectionPosition2 = genType(), genType & intersectionNormal2 = genType())

}