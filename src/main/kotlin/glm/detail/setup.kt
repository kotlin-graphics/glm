package glm.detail

/**
 * Created by GBarbieri on 14.12.2016.
 */

///////////////////////////////////////////////////////////////////////////////////
// Clip control

val GLM_DEPTH_ZERO_TO_ONE = 0x00000001
val GLM_DEPTH_NEGATIVE_ONE_TO_ONE = 0x00000002

var GLM_DEPTH_CLIP_SPACE = GLM_DEPTH_NEGATIVE_ONE_TO_ONE


///////////////////////////////////////////////////////////////////////////////////
// Coordinate system

val GLM_LEFT_HANDED = 0x00000001    // For DirectX, Metal, Vulkan
val GLM_RIGHT_HANDED = 0x00000002    // For OpenGL, default in GLM

var GLM_COORDINATE_SYSTEM = GLM_RIGHT_HANDED