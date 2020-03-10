####JDK1.8 安装

#####1.检查是否安装JDK
    
    rpm -qa | grep jdk
    

#####2.下载JDK安装包
    
    wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" https://download.oracle.com/otn/java/jdk/8u241-b07/1f5b5a70bf22433b84d0e960903adac8/jdk-8u241-linux-x64.rpm
    wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.rpm  

#####3.设置软件包执行权限
    
    chmod +x jdk-8u131-linux-x64.rpm


#####4.设置软件包执行权限
    
    rpm -ivh jdk-8u131-linux-x64.rpm
    
    
#####5.编辑环境变量
    
    vim /etc/profile
    
    export JAVA_HOME=/usr/java/jdk1.8.0_131
    export JRE_HOME=${JAVA_HOME}/jre
    export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib:$CLASSPATH
    export JAVA_PATH=${JAVA_HOME}/bin:${JRE_HOME}/bin
    export PATH=$PATH:${JAVA_PATH}
    
    source /etc/profile






####MySQL5.7 安装


#####1.下载
    
    wget https://dev.mysql.com/get/mysql80-community-release-el7-3.noarch.rpm
    
#####2.安装  
    chmod +x mysql80-community-release-el7-3.noarch.rpm
    yum install mysql80-community-release-el7-3.noarch.rpm
    yum search mysql-com
    yum install mysql-community-server.x86_64


#####3.启动    
    systemctl start mysqld.service
    
    
#####4.登录
    grep 'temporary password' /var/log/mysqld.log
    mysql -uroot -p
    

#####5.修改密码
        ALTER USER 'root'@'localhost' IDENTIFIED BY '复杂密码';
        
        
#####6.允许远程连接
        use mysql;
        select u.Host, u.User from user u;
        update user u set u.Host = '%' where u.User = 'root';