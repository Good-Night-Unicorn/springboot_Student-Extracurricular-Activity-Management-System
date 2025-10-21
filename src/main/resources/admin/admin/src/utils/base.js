const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot038x57l8/",
            name: "springboot038x57l8",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot038x57l8/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于JAVA的学生课外活动管理系统的设计与实现"
        } 
    }
}
export default base
