###Mycat+Mysql主从复制
    
   一.Mysql主从复制配置
        参考“Mysql 读写分离.md”
        
        
    二.Mycat搭建
        参考“Mycat 服务搭建.md”
        
         
    三.配置
        1.server.xml 中配置mycat帐号和逻辑数据库
            <user name="root">
                            <property name="password">123456</property>
                            <property name="schemas">TESTDB</property>
            
                            <!-- 表级 DML 权限设置 -->
                            <!--            
                            <privileges check="false">
                                    <schema name="TESTDB" dml="0110" >
                                            <table name="tb01" dml="0000"></table>
                                            <table name="tb02" dml="1111"></table>
                                    </schema>
                            </privileges>           
                             -->
                    </user>


        2.schema.xml 中配置物理数据库信息
            <!--mycat逻辑数据库和dataNode关系-->
            <schema name="TESTDB" checkSQLschema="false" sqlMaxLimit="100" dataNode="dn1"></schema>
            
            <!--mycat dataNode和mysql物理数据库关系-->
            <dataNode name="dn1" dataHost="localhost1" database="kbqa" />
            
            <!--dataNode和mysql连接配置-->
            <dataHost name="localhost1" maxCon="1000" minCon="10" balance="3"
                              writeType="0" dbType="mysql" dbDriver="native" switchType="1"  slaveThreshold="100">
                    <heartbeat>select user()</heartbeat>
                    <!-- can have multi write hosts -->
                    <writeHost host="hostM1" url="192.168.0.254:3306" user="root"
                                       password="vem.71VoTpq">
                            <!-- can have multi read hosts -->
                            <readHost host="hostS2" url="192.168.0.253:3306" user="root" password="vem.71VoTpq" />
                    </writeHost>
                    <writeHost host="hostS1" url="192.168.0.253:3306" user="root"
                                       password="vem.71VoTpq" />
                    <!-- <writeHost host="hostM2" url="localhost:3316" user="root" password="123456"/> -->
            </dataHost>

            
    
    服务器IP           服务器端口       描述
    192.168.0.254       3306            Master
    192.168.0.253       3306            Slave
    192.168.0.254       3306            Mycat