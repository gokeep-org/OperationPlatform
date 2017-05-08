/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-4-14
 ****************************************/
public class UtilMain {
    /**
     * 由于spring-boot打包需要打包成可执行的jar包，必须要招待主函数，
     * 但是，这是一个提供给所有服务引用的类库项目，是不不需要可执行的，
     * 这个主函数即便执行，可是停止课前主函数运行的java虚拟机
     * @param args
     */
    public static void main(String[] args) {
        System.exit(0);
    }
}
