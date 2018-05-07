package cn.kisoo.forest.constant

object URL{


    const val baseUrl = "http://119.23.23.144:8080"
    /***
     * User
     */
    const val REGISTER_URL = "/user/register"//注册 入参User 返回null
    const val LOGIN_URL = "/user/login"//用户登陆 入参String username,String  password		成功返回user 失败null
    const val MODIFY_PWD_URL =  "/user/modifyPwd"//修改用户密码 入参User 成功返回user 失败null
    const val MODIFY_USER_URL =  "/user/modifyUser"//修改用户信息 入参String username,String  password 成功返回user 失败null
    const val GET_USER_URL =  "/user/getUserByUid"//得到单个用户的全部信息 入参User 成功返回user 失败null

    /***
     * Task
     */

    const val INSERT_TASK_URL =  "/task/insertTask"//用户上传成就 	入参TaskVO 返回null
    const val GET_TASK_LIST_URL =  "/task/getTaskListByUid" ///得到当前用户的已完成任务列表 入参uid 返回List<TaskVO>
    const val GET_TASK_URL =  "/task/getTaskByTid" ///    查看任务具体信息	入参tid	 返回TaskVO
    const val GET_ACHI_URL =  "/userachi/getUserAchiVOList" //根据用户id得到用户当前的成就，以及总时长，等信息

    /***
     * white list
     */

    const val GET_WHITE_LIST =  "/whitelist/getWhitelistByUid" //获取白名单
    const val UPLOAD_WHITE_LIST =  "/whitelist/insertWhitelist" //上传whitelist
    const val MODIFY_WHITE_LIST =  "/whitelist/modifyWhitelist" //修改whitelist

    /***
     * 课表
     */
    const val USER_COURSE =  "/stuCourse/getUserCourse" //获得课表
}
