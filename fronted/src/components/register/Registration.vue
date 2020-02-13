<template>
  <el-container>
    <el-aside width="40%">
      <el-form :inline="true" :model="formInline" class="lookup">
        <el-form-item label="病历号" >
          <el-input v-model="formInline.historyID" placeholder="请输入病历号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="reload">重置</el-button>
        </el-form-item>
      </el-form>
      <el-table
        :data="registrationTable"
        ref="registrationTable"
        style="width: 100%"
        height="400"
        @row-click="selectRow"
        >
        <el-table-column
          prop="id"
          label="挂号ID"
          sortable
          width="100px">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          sortable
          width="100px">
        </el-table-column>
        <el-table-column
          prop="idNumber"
          label="身份证号"
          sortable
          width="200px">
        </el-table-column>
        <el-table-column
          prop="medicalHistoryId"
          label="病历号"
          sortable
          width="150px">
        </el-table-column>
        <el-table-column
          prop="state"
          label="挂号状态"
          sortable
          width="50px">
        </el-table-column>
      </el-table>
    </el-aside>
    <el-main >
      <el-form :model="ruleForm" :rules="rules"  ref="ruleForm" class="demo-ruleForm" >
        <el-row :gutter=50>
          <el-col :span="6">
            <el-form-item label="患者病历号" prop="medicalHistoryId" >
              <el-input v-model="ruleForm.medicalHistoryId" :disabled="true"></el-input>
            </el-form-item>

          </el-col>
          <el-col :span="6">
            <el-form-item label="患者身份证号" prop="idNumber" >
              <el-input v-model="ruleForm.idNumber" ></el-input>
            </el-form-item>

          </el-col>
          <el-col :span="6">
            <el-form-item label="患者姓名" prop="name" >
              <el-input v-model="ruleForm.name" :clearable="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="年龄" prop="age">
              <el-input v-model="ruleForm.age" :clearable="true"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="50">
          <el-col :span="6">
            <el-form-item label="性别" prop="gender" >
              <el-select v-model="ruleForm.gender" style="width: 100%" placeholder="请选择性别">
                  <el-option label="男" value="71"></el-option>
                <el-option label="女" value="72"></el-option>
              </el-select>
            </el-form-item>

          </el-col>
          <el-col :span="6">
            <el-form-item label="患者生日" prop="birthDate">
              <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.birthDate" style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="看诊日期" prop="date">
              <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.date" style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="午别" prop="morningAfternoon">
              <el-input v-model="ruleForm.morningAfternoon"></el-input>
            </el-form-item>
          </el-col>



        </el-row>
        <el-row :gutter="50">
          <el-col :span="6">
            <el-form-item label="选择挂号时间" prop="registrationTime">
              <el-date-picker
                v-model="ruleForm.registrationTime"
                type="datetime"
                placeholder="选择挂号时间">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="选择科室" prop="departmentId">
              <el-select v-model="ruleForm.departmentId" style="width: 100%" placeholder="请选择科室" >
                <el-option v-for="department in departments" :label="department.name" :value="department.id"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="选择挂号级别" prop="registrationLevel">
              <el-select v-model="ruleForm.registrationLevel" style="width: 100%" placeholder="请选择挂号级别" @change="loadDoctor">
                <el-option label="普通号" value="166"></el-option>
                <el-option label="专家号" value="165"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="选择医生" prop="doctorId">
              <el-select v-model="ruleForm.doctorId" style="width: 100%"  placeholder="请选择医生" >
                <el-option v-for="doctor in doctors" :label="doctor.realName" :value="doctor.id"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="100">
          <el-col :span="8">
            <el-form-item label="结算类别" prop="paymentType" >
              <el-select v-model="ruleForm.paymentType" style="width: 100%" placeholder="请选择结算类别">
                <el-option label="自费" value="1"></el-option>
                <el-option label="医保" value="2"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">

            <el-form-item label="病历本" prop="needHistorybook">
              <el-select v-model="ruleForm.needHistorybook" style="width: 100%" placeholder="请选择是否购买病历本" @change="loadRegistrationFee">
                <el-option label="是" value="1"></el-option>
                <el-option label="否" value="0"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="应收金额" prop="registrationFee" >
              <el-input v-model="ruleForm.registrationFee" :disabled="true"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>
</template>

<script>
  export default {
    name:'Registration',
    data() {
      return {
        formInline: {
          historyID:'',
        },
        registrationTable: [],
        departments:[],
        doctors:[],
        ruleForm: {
          medicalHistoryId:'',
          idNumber:'',
          name: '',
          age:'',
          ageType:'',
          address:'',
          date:'',
          morningAfternoon:'',
          gender:'',
          birthDate:'',
          departmentId:'',
          registrationLevel:'',
          doctorId:'',
          paymentType:'',
          needHistorybook:'',
          registrationFee:'',
          register:'',
          registrationTime:'',
          state:''
        },
        rules: {
          idNumber: [
            { required: true, message: '请输入身份证号', trigger: 'blur' },
            { min: 18, max: 18, message: '长度为18位字符', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '请输入年龄', trigger: 'blur' },
          ],
          morningAfternoon: [
            { required: true, message: '请输入午别', trigger: 'blur' },
          ],
          date: [
            { required: true, message: '请选择看诊日期', trigger: 'blur' },
          ],
          gender: [
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
          birthDate: [
            { required: true, message: '请选择出生日期', trigger: 'change' }
          ],
          registrationTime: [
            { required: true, message: '请选择挂号时间', trigger: 'change' }
          ],
          registrationLevel:[
            {required:true,message:'请选择挂号级别',trigger:'change'}
          ],
          departmentId: [
            { required: true, message: '请选择科室', trigger: 'change' }
          ],
          doctorId: [
            { required: true, message: '请选择医生', trigger: 'change' }
          ],
          paymentType: [
            { required: true, message: '请选择结算类别', trigger: 'change' }
          ],
          needHistorybook: [
            { required: true, message: '请选择是否购买病历本', trigger: 'change' }
          ],
        }
    }},
    mounted: function(){
      this.loadRegistration();
      this.loadDepartment();
      this.loadHistoryId();

    },
    methods: {
      loadDoctor(){
        var _this=this
        var params=new URLSearchParams();
        params.append('departmentId',this.ruleForm.departmentId);
        params.append('registrationLevel',this.ruleForm.registrationLevel);
        this.$axios.post('/doctor/select',params).then(resp => {
          if (resp) {
            _this.doctors = resp.data
          }
        });
      },
      loadRegistrationFee(){
        var _this=this
        var params=new URLSearchParams();
        params.append('id',this.ruleForm.registrationLevel);
        this.$axios.post('/registrationFee',params).then(resp => {
          if (resp) {
            _this.ruleForm.registrationFee=resp.data
          if(_this.ruleForm.needHistorybook==="1"){
            _this.ruleForm.registrationFee+=1
          }else {
            _this.ruleForm.registrationFee=registrationFee
          }
        }})
      },
      loadRegistration(){
        var _this=this
        this.$axios.get('/registration').then(resp => {
          if (resp) {
            _this.registrationTable = resp.data

          }
        })
      },
      loadHistoryId(){
        var _this=this
        this.$axios.get('/registration/historyId').then(resp=>{
          if(resp){
            _this.ruleForm.medicalHistoryId=resp.data
          }
        })
      },
      loadDepartment(){
        var _this=this
        this.$axios.get('/department').then(resp=>{
          if (resp){
            _this.departments=resp.data
          }
        })
      },
      onSubmit() {
        var _this=this
        var params=new URLSearchParams();
        params.append('medicalHistoryId',this.formInline.historyID);
        this.$axios.post('/registration/search',params).then(resp => {
          if (resp) {
            _this.registrationTable = resp.data
          }
        })
      },

      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var _this=this
            this.$axios.post('/registration/add',
              {medicalHistoryId:this.ruleForm.medicalHistoryId,
                name:this.ruleForm.name,
                gender:this.ruleForm.gender,
                idNumber:this.ruleForm.idNumber,
                birthDate:this.ruleForm.birthDate,
                age:this.ruleForm.age,
                ageType:this.ruleForm.ageType,
                address:this.ruleForm.address,
                date:this.ruleForm.date,
                morningAfternoon:this.ruleForm.morningAfternoon,
                departmentId:this.ruleForm.departmentId,
                doctorId:this.ruleForm.doctorId,
                registrationLevel:this.ruleForm.registrationLevel,
                paymentType:this.ruleForm.paymentType,
                needHistorybook:this.ruleForm.needHistorybook,
                registrationTime:this.ruleForm.registrationTime,
                register:this.ruleForm.register,
                state:this.ruleForm.state
              }
              ).then(resp=>{
              if(resp){
                alert("提交成功")
                this.loadHistoryId()
              }
            })
          } else {
            console.log('error submit!!');
            alert("提交失败")
            return false;
          }
        });
      },

      reload(){
        this.loadRegistration();
      },

      resetForm(formName) {
        this.$refs[formName].resetFields();
        this.loadHistoryId();
      },
      selectRow(row){
        this.ruleForm.medicalHistoryId=row.medicalHistoryId;
        this.ruleForm.idNumber=row.idNumber;
        this.ruleForm.name=row.name;
        this.ruleForm.gender=row.gender;
        this.ruleForm.birthDate=row.birthDate;
        this.ruleForm.age=row.age;
        console.log(row)
      }
    }
  }
</script>

<style>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
  .lookup{
    margin-top: 30px;
  }
</style>
