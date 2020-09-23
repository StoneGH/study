### Mysql 读写分离
    ####一.配置Master
        1.配置my.cnf
            server-id=254
            log_bin=bin-log
            log_bin_index=bin-log.index
            innodb_file_per_table=ON
            skip_name_resolve=ON
            binlog_do_db=kbqa
        重启mysql服务
        
        2.创建slave和master通信的用户账号
            grant replication slave on *.* to '帐号'@'IP地址' identified by '密码';
            flush privileges;
    
        3. 获得master二进制日志文件名及位置
            show master status
        
        
    ####二.配置Slave
        1.配置my.cnf
            server-id=253
            log-bin=mysql-bin
            binlog_format=MIXED
            relay-log=relay-log
            relay-log-index=relay-log.index
            

        2.从库设置复制主库数据账号
            change master to master_host='主库 IP',master_user='主库 用户名',master_password='主库密码',master_log_file='主库binlog文件',master_log_pos=位置;
            

        3.启动Slave复制
            start slave;
            

        4.查看主从复制状态
            show slave status;
            
            
            
            
参考：https://www.ljwit.com/archives/database/975.html