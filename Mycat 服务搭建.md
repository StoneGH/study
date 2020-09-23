###Mycat 服务配置

    前提：需要JAVA环境

   1.Mycat官方Github下载服务端
        cd /usr/local/src
        wget https://github.com/MyCATApache/Mycat-download/blob/master/1.6-RELEASE/Mycat-server-1.6-RELEASE-20161028204710-linux.tar.gz
        tar -zxvf Mycat-server-1.6-RELEASE-20161028204710-linux.tar.gz
        mv mycat/ /usr/local/
        cd /usr/local/mycat
        
    2.添加mysql用户及修改文件夹权限
        useradd mycat
        echo "mycat:123456" | chpasswd
        （chpasswd命令 是批量更新用户口令的工具，是把一个文件内容重新定向添加到/etc/shadow中。）
        chown -R mycat:mycat /usr/local/mycat/
        
        
        
        
        
    3.Server.xml配置
        ./conf/server.xml
        
        
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
        
                <user name="user">
                        <property name="password">user</property>
                        <property name="schemas">TESTDB</property>
                        <property name="readOnly">true</property>
                </user>
    
    
        创建user帐号用于连接MyCAT中间件：
        root用户对逻辑数据库TESTDB具有增删改查的权限，也即WEB连接MyCAT的用户名和密码；
        user用户对逻辑数据库TESTDB只读的权限；
        
        
        
        
    4.Schema.xml配置
        签用于定义 MyCat 实例中的逻辑库，MyCat 可以有多个逻辑库，每个逻辑库都有自己的相关配置
        
        
        
        
        
        
        
        
        
        
        
    server.xml Mycat的配置文件，设置账号、参数等
    schema.xml Mycat对应的物理数据库和数据库表的配置
    rule.xml Mycat分片（分库分表）规则