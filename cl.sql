create table constant_item
(
    id               varchar(11) not null
        primary key,
    constant_type_id varchar(11) not null comment '常数类别',
    constant_code    varchar(64) not null comment '常数项编码',
    constant_name    varchar(64) not null comment '常数项名字',
    price            varchar(10) null comment '价格'
)
    charset = utf8;

create index ConstantTypeID
    on constant_item (constant_type_id);

create table constant_type
(
    id                 varchar(11) not null
        primary key,
    constant_type_code varchar(64) null comment '常数类别编码',
    constant_type_name varchar(64) null comment '常数类别名字'
)
    charset = utf8;

create table department
(
    id          varchar(11) not null comment '科室'
        primary key,
    code        varchar(64) not null comment '科室编码',
    name        varchar(64) not null comment '科室名称',
    category_id varchar(11) not null comment '科室分类',
    is_delete   char        not null comment '删除标记'
)
    charset = utf8;

create table diagnose
(
    id                 int(255) not null comment 'ID主键'
        primary key,
    medical_history_id int(255) null comment '病历ID',
    registration_id    int(255) null comment '挂号ID',
    disease_id         int(255) null comment '疾病ID',
    diagnose_type      int(255) null comment '诊断类型 1-西医 2-中医',
    date               date     null comment '发病日期',
    diagnose_time      int(255) null comment '诊断种类 1-初诊 2-终诊'
)
    engine = MyISAM
    charset = utf8;

create table dise_category
(
    id                 varchar(11) not null
        primary key,
    dise_category_code varchar(64) null,
    dise_category_name varchar(64) null,
    sequence_number    varchar(64) null,
    dise_category_type char        null
)
    engine = MyISAM
    charset = utf8;

create table disease
(
    id               int         not null
        primary key,
    disease_code     varchar(64) null,
    disease_name     varchar(64) null,
    disease_ICD      varchar(11) null,
    dise_category_id varchar(11) null
)
    engine = MyISAM
    charset = utf8;

create table drugs
(
    id            varchar(11)  not null
        primary key,
    drugs_code    varchar(64)  not null comment '药品编码',
    drugs_name    varchar(64)  not null comment '药品名称',
    drugs_format  varchar(64)  not null comment '药品规格',
    drugs_unit    char         not null comment '包装单位',
    manufacturer  varchar(64)  null comment '生产厂家',
    drugs_price   float(11, 0) not null comment '药品单价',
    mnemonic_code varchar(64)  not null comment '拼音助记码',
    creation_date varchar(11)  not null comment '创建时间'
)
    engine = MyISAM
    charset = utf8;

create table examine_dispose_application
(
    id                   varchar(11)  not null comment 'ID主键'
        primary key,
    history_id           varchar(11)  null comment '病历ID',
    registration_id      varchar(11)  null comment '挂号ID',
    item_id              varchar(64)  null comment '项目ID',
    item_name            varchar(64)  null comment '项目名称',
    requiment            varchar(255) null comment '目的要求',
    part                 varchar(64)  null comment '检查部位',
    is_emergency         char         null comment '是否加急 1为加急 0为不加急',
    amount               varchar(11)  null comment '数量',
    creat_time           datetime     null comment '开立时间',
    doctor_id            varchar(11)  null comment '开立医生ID',
    technician_doctor_id varchar(11)  null comment '检察人员ID',
    result_doctor_id     varchar(11)  null comment '结果录入人员ID',
    examine_time         datetime     null comment '检查时间',
    result               varchar(255) null comment '检查结果',
    result_time          datetime     null comment '结果时间',
    state                varchar(11)  null comment '状态',
    type                 char         null comment '记录类型 1-检查 2-检验 3-处置'
)
    engine = MyISAM
    charset = utf8;

create table expense
(
    medicalHistoryId int                           not null
        primary key,
    name             varchar(255) collate utf8_bin null,
    itemName         varchar(255) collate utf8_bin null,
    price            decimal(10, 2)                null,
    amount           varchar(255) collate utf8_bin null,
    state            varchar(255) collate utf8_bin null
);

create table expense_detail
(
    id              int         not null comment 'ID主键'
        primary key,
    registration_id int         not null comment '挂号ID',
    invoice_id      int         not null comment '发票ID',
    item_type       int         not null comment '项目类型 1-非药品 2-药品',
    item_name       varchar(64) not null comment '项目名称',
    item_price      int         not null comment '项目单价',
    amount          int         not null comment '数量',
    department_id   int         not null comment '执行科室ID',
    pay_refund_time datetime    not null comment '收/退费时间',
    pay_user_id     int         not null comment '收/退费人员ID',
    pay_type        int         not null
)
    engine = MyISAM
    charset = utf8;

create table f_med_item
(
    id            varchar(11) not null
        primary key,
    item_code     varchar(11) null,
    item_name     varchar(64) null,
    format        varchar(64) null,
    price         varchar(11) null,
    exp_class_id  varchar(11) null,
    dept_id       varchar(11) null,
    mnemonic_code varchar(64) null,
    record_type   varchar(11) null comment '1检查2检验3处置',
    creation_date varchar(11) null
)
    engine = MyISAM
    charset = utf8;

create table history
(
    id                  int auto_increment
        primary key,
    medicalHistoryId    int                           null,
    chiefComplaint      varchar(255) collate utf8_bin null,
    allergy             varchar(255) collate utf8_bin null,
    physicalExamination varchar(255) collate utf8_bin null,
    historyOfPresent    varchar(255) collate utf8_bin null,
    treatmentCondition  varchar(255) collate utf8_bin null
);

create table invoice
(
    id              int          not null
        primary key,
    amount          int          null,
    date            datetime     null,
    registor_id     int          null,
    registration_id int          null,
    method          varchar(255) null,
    red_number      int          null
)
    engine = MyISAM
    charset = utf8;

create table prescription
(
    id                 int(255)     not null comment 'ID主键'
        primary key,
    medical_history_id int(255)     null comment '病历ID',
    registration_id    int(255)     null comment '挂号ID',
    doctor_id          int(255)     null comment '开立医生ID',
    prescription_name  varchar(255) null comment '处方名称',
    time               datetime     null comment '开立时间',
    state              int(255)     null comment '处方状态'
)
    engine = MyISAM
    charset = utf8;

create table prescription_detail
(
    id              int(255)     not null comment 'ID主键'
        primary key,
    prescription_id int(255)     null comment '成药处方ID',
    drug_id         int(255)     null comment '药品ID',
    use_method      varchar(255) null comment '用法',
    use_amount      varchar(255) null comment '用量',
    use_times       varchar(255) null comment '频次',
    amount          int(255)     null comment '数量',
    state           int(255)     null comment '状态'
)
    engine = MyISAM
    charset = utf8;

create table registration
(
    id                 int auto_increment comment 'ID主键'
        primary key,
    medical_history_id int         null comment '病历号',
    name               varchar(64) null comment '姓名',
    gender             varchar(11) null comment '性别',
    id_number          varchar(64) null comment '身份证号',
    birth_date         date        null comment '出生日期',
    age                int         null comment '年龄',
    age_type           varchar(11) null comment '年龄类型 岁 月 天',
    address            varchar(64) null comment '家庭住址',
    date               date        null comment '本次看诊日期',
    morning_afternoon  varchar(11) null comment '午别  上午/下午',
    department_id      int         null comment '本次挂号科室ID',
    doctor_id          int         null comment '本次挂号医生ID',
    registration_level varchar(11) null comment '本次挂号级别ID',
    payment_type       varchar(11) null comment '结算类别ID',
    need_historybook   varchar(1)  null comment '病历本要否  是/否',
    registration_time  datetime    null comment '挂号时间',
    register           varchar(11) null comment '挂号员',
    state              varchar(11) null comment '本次看诊状态'
)
    charset = utf8;

create index department_id
    on registration (department_id);

create index doctor_id
    on registration (doctor_id);

create table schedule
(
    id                varchar(11) not null comment 'ID主键'
        primary key,
    department_id     varchar(11) not null comment '科室ID',
    doctor_id         varchar(11) not null comment '医生ID',
    morning_afternoon varchar(11) not null comment '午别',
    schedule_rule_id  varchar(11) not null comment '排班规则ID',
    is_delete         char        not null comment '删除标记',
    date              date        null
)
    engine = MyISAM
    charset = utf8;

create table user
(
    id                int(11) unsigned auto_increment
        primary key,
    username          varchar(64) not null comment '登录名',
    password          varchar(64) not null comment '登录密码',
    real_name         varchar(64) not null comment '真实姓名',
    category_id       varchar(11) not null comment '用户类别',
    title_id          varchar(11) not null comment '医生职称',
    is_schedule       char        not null comment '是否排班',
    departmentId      varchar(11) not null comment '科室',
    registrationLevel char(11)    not null comment '挂号级别',
    is_delete         char        not null comment '删除标记',
    authority         int(255)    not null
)
    charset = utf8;

create index department_id
    on user (departmentId);

create
    definer = root@localhost procedure Registration(IN PATIENTNAME text, IN SEX int, IN IDCARD text, IN BIRTHTIME text,
                                                    IN AGE int, IN AGETYPE text, IN FAMILYADDRESS text, IN RDATE text,
                                                    IN NOON text, IN RegDepartmentID int, IN RegDoctorID int,
                                                    IN RegRank int, IN SettleType int, IN MedicalRecordorNNOT int,
                                                    IN CollectorID int, IN State int, OUT A text)
BEGIN
    declare currenttime time;
    declare AvailableMedicalNumber INT DEFAULT 0;#查询历史病历号
    DECLARE MedHisNum INT;#可用病历号
    declare RegID INT;
    set currenttime = sysdate();
    SELECT MAX(medical_history_id) + 1 FROM registration INTO MedHisNum;
    SELECT medical_history_id
    into AvailableMedicalNumber
    from registration
    where id_number = IDCARD;
#如果查到有就用历史的，没有就生成
    if AvailableMedicalNumber = 0 then
        set AvailableMedicalNumber = MedHisNum;
    end if;
    SELECT MAX(id) + 1 FROM registration INTO RegId;
    insert into registration(id, medical_history_id, name, gender, id_number, birth_date, age, age_type, address, date,
                             morning_afternoon, department_id, doctor_id, registration_level, payment_type,
                             need_historybook, registration_time, register, state)
    values (RegID, AvailableMedicalNumber, PATIENTNAME, SEX, IDCARD,
            BIRTHTIME, AGE, AGETYPE, FAMILYADDRESS, RDATE, NOON, RegDepartmentID, RegDoctorID, RegRank, SettleType,
            MedicalRecordorNNOT,
            currenttime, CollectorID, State);
    set A = '操作成功';
END;

create
    definer = root@localhost procedure backRegistration(IN RegID int, OUT Result text)
BEGIN
    DECLARE MedicalState INT;#就诊状态
    select state from registration where id = RegID into MedicalState;
    #找出挂号ID对应的就诊状态
#就诊状态为3待诊则更新状态并操作成功，为4已诊则操作失败
    if MedicalState = 3 then
        set MedicalState = 4;
        update registration set state = MedicalState where id = RegID;
        set Result = '操作成功 已经退号';
    else
        set Result = '操作失败 正在就诊中';
    end if;
END;

create
    definer = root@localhost procedure diagnose(IN registerID int, IN diseaseN varchar(20), OUT result text)
BEGIN
    declare record_ID int;#病历号
    declare disease_id int;#疾病号
    declare zhendID int;#诊断号
    declare a int;
    declare b int;
    DECLARE CURRTIME TEXT;
    SET CURRTIME = NOW();
#找出挂号号对应的病历号
    select medical_history_id
    into record_ID
    from registration
    where id = registerID;
    select id
    into disease_id
    from disease
    where disease_name = diseaseN;
#主键递增
    select max(id) into a from diagnose;
    set zhendID = a + 1;
#保存诊断信息
    insert into diagnose (id, medical_history_id, registration_id, disease_id, diagnose_type, date, diagnose_time)
    values (zhendID, record_ID, registerID, disease_id, 1, CURRTIME, 1);
#更新挂号的诊断状态
    update registration
    set state=2
    where id = registerID;
    select id
    into b
    from disease
    where disease_name = diseaseN;
    if b = disease_id then
        set result = '操作成功';
    else
        set result = '操作失败';
    end if;
END;

create
    definer = root@localhost procedure dispensing(IN MedHisID int, OUT A text)
BEGIN
    declare RecipeID INT;#处方号
    declare State INT;#处方状态
    SET SQL_SAFE_UPDATES = 0;
#更新处方和处方明细状态
    update prescription set state = 4 where medical_history_id = MedHisID;
    update prescription_detail
    set state = 4
    where prescription_id in (select id from prescription where medical_history_id = MedHisID);
    set A = '操作成功';
END;

create
    definer = root@localhost procedure pay(IN RecipeID int, IN OperatorID int, OUT A text)
BEGIN
    declare AvailableInvoice INT;-- 可用的发票ID
    declare FeedetailID INT;-- 费用明细ID
    declare RegID INT;-- 挂号ID
    declare countt INT default 0;
    declare MedID INT;
    declare MedNumber INT;#药品数量
    declare Medcount INT;#处方中的药品数量
    declare MedName TEXT;#药品名称
    declare MedFee double;
    declare Currtime TEXT;
    declare TotalFee double default 0;
    declare totalfe double default 0;
    declare i INT default 0;
#为输入的处方表建立游标
    declare cs cursor for
        select drug_id, amount
        from prescription_detail
        where prescription_id = RecipeID;
    SET SQL_SAFE_UPDATES = 0;
#更新处方状态
    update prescription set state = 2 where id = RecipeID;
    update prescription_detail set state = 2 where prescription_id = RecipeID;
#获取可用的发票号ID
    select MAX(id) from invoice into AvailableInvoice;
#获取处方对应的挂号ID
    select registration_id from prescription where id = RecipeID into RegID;
#获取处方中的药品数量
    select count(*) into Medcount from prescription_detail where prescription_id = RecipeID;
    set Currtime = now();
    open cs;
    repeat
        fetch cs into MedID,MedNumber;#将药品ID和数量分别放入两个变量中
        select drugs_name from drugs where id = MedID into MedName;#获取药品名称
        select drugs_price from drugs where id = MedID into MedFee;#获取药品单价
        set TotalFee = MedFee * MedNumber;
        set totalfe = totalfe + TotalFee;
        select MAX(id) from expense_detail into FeedetailID;#获取可用明细ID
        insert into expense_detail(id, registration_id, invoice_id, item_type, item_name, item_price, amount,
                                   department_id, pay_refund_time, pay_user_id, pay_type)
        values (FeedetailID + 1, RegID, InvoiceN + 1, 2, MedName, MedFee, MedNumber, 132, Currtime, OperatorID, 51);
        set i = i + 1;
    until i >= Medcount end repeat;
#新增发票记录
    insert into invoice(id, amount, date, registor_id, registration_id, method, red_number)
    values (AvailableInvoice + 1, totalfe, Currtime, OperatorID, RegID, 51, 0);
    set A = '操作成功';
END;

create
    definer = root@localhost procedure prescribe(IN RegID int, IN RecipeName text, IN MedcineList text, OUT A text)
BEGIN
    declare RecipeID INT;
    declare MedHistoryID INT;
    declare DoctorID INT;
    declare DetailID INT;
    declare counta INT default 0;
    declare i INT default 0;

    declare p_drugID INT;
    declare p_drugUnitPrice double;
    declare p_usage TEXT;
    declare p_dosage TEXT;
    declare p_frequency TEXT;
    declare p_amount INT;

    declare st TEXT;
    declare _index1 INT(11);
    declare _index2 INT(11);

    #为临时表创建游标
    declare CS cursor for
        select v_drugID, v_usage, v_dosage, v_frequency, v_amount
        from tmp_strs;
    drop temporary table if exists tmp_strs;
    #创建临时表用来保存处方明细信息
    create temporary table tmp_strs
    (
        v_drugID    INT,
        v_usage     TEXT,
        v_dosage    TEXT,
        v_frequency TEXT,
        v_amount    Int
    );

    set _index1 = LOCATE('/', MedcineList);#一级分割
    while _index1 > 0
        do
            set st = left(MedcineList, _index1-1);
            set _index2 = LOCATE('*', st);#创建二级分割
            set p_drugID = left(st, _index2-1);#赋值药品ID
            set st = substr(st from _index2+1);

            set _index2 = LOCATE('*', st);
            set p_usage = left(st, _index2-1);#赋值药品用法
            set st = substr(st from _index2+1);

            set _index2 = LOCATE('*', st);
            set p_dosage = left(st, _index2-1);#赋值药品用量
            set st = substr(st from _index2+1);

            set _index2 = LOCATE('*', st);
            set p_frequency = left(st, _index2-1);#赋值药品频次
            set st = substr(st from _index2+1);

            set _index2 = LOCATE('*', st);
            set p_amount = left(st, _index2+1);
            #赋值药品数量
            #以上信息插入临时表中
            select p_drugID, p_usage, p_dosage, p_frequency, p_amount;
            insert into tmp_strs values (p_drugID, p_usage, p_dosage, p_frequency, p_amount);

            set MedcineList = substr(MedcineList from _index1+1);
            set _index1 = LOCATE('/', MedcineList);
        end while;
    if LENGTH(MedcineList) >= 0 then
        set _index2 = LOCATE('*', MedcineList);
        set p_drugID = left(MedcineList, _index2-1);
        set MedcineList = substr(MedcineList FROM _index2+1);

        set _index2 = LOCATE('*', MedcineList);
        set p_usage = left(MedcineList, _index2-1);
        set MedcineList = substr(MedcineList from _index2+1);

        set _index2 = LOCATE('*', MedcineList);
        set p_dosage = left(MedcineList, _index2-1);
        set MedcineList = substr(MedcineList from _index2+1);

        set _index2 = LOCATE('*', MedcineList);
        set p_frequency = left(MedcineList, _index2-1);
        set MedcineList = substr(MedcineList from _index2+1);

        set _index2 = LOCATE('*', MedcineList);
        set p_amount = MedcineList;

        select p_drugID, p_usage, p_dosage, p_frequency, p_amount;
        insert into tmp_strs values (p_drugID, p_usage, p_dosage, p_frequency, p_amount);
    end if;
    select MAX(id) from prescription into RecipeID;
    select doctor_id from registration where id = RegID into DoctorID;
    select medical_history_id from registration where id = RegID into MedHistoryID;
    insert into prescription values (RecipeID + 1, MedHistoryID, RegID, DoctorID, RecipeName, NOW(), 1);
    select count(*) from tmp_strs into counta;

    open CS;
    repeat
        fetch CS into p_drugID,p_usage,p_dosage,p_frequency,p_amount;
        select MAX(id) from prescription into DetailID;
        insert into prescription_detail
        values (DetailID + 1, RecipeID + 1, p_drugID, p_usage, p_dosage, p_frequency, p_amount, 1);
        set i = i + 1;
    until i >= counta end repeat;
    set A = '操作成功';
END;

create
    definer = root@localhost procedure refund(IN RecipeID int, IN InvoiceID int, IN OperatorID int, OUT A text)
BEGIN
    declare RegID INT;
    declare counta INT;
    declare MedName TEXT;
    declare MedPrice double;
    declare MedNumber INT;
    declare DEP INT;
    declare FeedetailID INT;
    declare AvailableInvoice INT;
    declare CurrTime TIME;
    declare TotalFee double;
    declare i INT default 0;
#为指定患者费用明细建立游标
    declare CS cursor for
        select registration_id, item_name, item_price, amount, department_id
        from expense_detail
        where invoice_id = InvoiceID;
    SET SQL_SAFE_UPDATES = 0;
#更新处方和明细状态
    update prescription set state = 3 where id = RecipeID;
    update prescription_detail set state = 3 where prescription_id = RecipeID;

#获取可用的发票号ID
    select MAX(id) from invoice into AvailableInvoice;
    select count(*) from expense_detail where invoice_id = InvoiceID into counta;
    set CurrTime = now();
    open CS;
    repeat
        fetch CS into RegID,MedName,MedPrice,MedNumber,DEP;
        select MAX(id) from expense_detail into FeedetailID;#获取可用明细ID
        insert into expense_detail(id, registration_id, invoice_id, item_type, item_name, item_price, amount,
                                   department_id, pay_refund_time, pay_user_id, pay_type)
        values (FeedetailID + 1, RegID, AvailableInvoice + 1, 2, MedName, MedPrice * (-1), MedNumber, DEP, CurrTime,
                OperatorID, 51);
        SET i = i + 1;
    until i >= counta end repeat;
    update invoice set red_number = AvailableInvoice + 1 where id = RecipeID;
    select amount from invoice where id = InvoiceID into TotalFee;
    insert into invoice(id, amount, date, registor_id, registration_id, method, red_number)
    values (AvailableInvoice + 1, TotalFee * (-1), CurrTime, OperatorID, RegID, 51, 0);
    set A = '操作成功';
END;

