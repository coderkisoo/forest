package cn.kisoo.forest.constant

object URL{


    const val baseUrl = "www.baidu.com"
    /***
     * User
     */
    const val REGISTER_URL = "$baseUrl/user/register"//注册 入参User 返回null
    const val LOGIN_URL = "$baseUrl/user/login"//用户登陆 入参String username,String  password		成功返回user 失败null
    const val MODIFY_PWD_URL =  "$baseUrl/user/modifyPwd"//修改用户密码 入参User 成功返回user 失败null
    const val MODIFY_USER_URL =  "$baseUrl/user/modifyUser"//修改用户信息 入参String username,String  password 成功返回user 失败null
    const val GET_USER_URL =  "$baseUrl/user/getUserByUid"//得到单个用户的全部信息 入参User 成功返回user 失败null

    /***
     * Task
     */

    const val INSERT_TASK_URL =  "$baseUrl/task/insertTask"//用户上传成就 	入参TaskVO 返回null
    const val GET_TASK_LIST_URL =  "$baseUrl/task/getTaskListByUid" ///得到当前用户的已完成任务列表 入参uid 返回List<TaskVO>
    const val GET_TASK_URL =  "$baseUrl/task/getTaskByTid" ///    查看任务具体信息	入参tid	 返回TaskVO
    const val GET_ACHI_URL =  "$baseUrl/userachi/getUserAchiVOList" //根据用户id得到用户当前的成就，以及总时长，等信息

}
