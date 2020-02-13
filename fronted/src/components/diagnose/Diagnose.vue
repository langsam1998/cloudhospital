<template>
  <el-container>
    <el-aside width="500px">

      <el-tabs v-model="activeName" type="border-card">
        <el-tab-pane label="已诊患者" name="yes">
          <el-form :inline="true" >
            <el-form-item label="患者姓名">
              <el-input placeholder="请输入患者姓名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" >查询</el-button>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" >重置</el-button>
            </el-form-item>
          </el-form>
          <el-table
            :data="finishedRegistrationTable"
            ref="registrationTable"

            height="400"
          >
            <el-table-column
              prop="name"
              label="姓名"
              width="100px">
            </el-table-column>
            <el-table-column
              prop="medicalHistoryId"
              label="病历号"
              width="150px">
            </el-table-column>
            <el-table-column
              prop="age"
              label="年龄"
              width="50px">
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="未诊患者" name="no">
          <el-form :inline="true" >
            <el-form-item label="患者姓名">
              <el-input placeholder="请输入患者姓名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" >查询</el-button>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" >重置</el-button>
            </el-form-item>
          </el-form>
          <el-table
            :data="unfinishedRegistrationTable"
            ref="registrationTable"
            style="width: 100%"
            height="400"
            @row-click="selectRow"
          >
            <el-table-column
              prop="name"
              label="姓名"
              width="100px">
            </el-table-column>
            <el-table-column
              prop="medicalHistoryId"
              label="病历号"
              width="150px">
            </el-table-column>
            <el-table-column
              prop="age"
              label="年龄"
              width="50px">
            </el-table-column>
          </el-table>
        </el-tab-pane>
      </el-tabs>

    </el-aside>
    <el-main>
      <el-form :inline="true" :model="patientInfo">
        <el-form-item label="患者姓名">
          <el-input v-model="patientInfo.name" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="病历号">
          <el-input v-model="patientInfo.medicalHistoryId" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="patientInfo.age" :disabled="true"></el-input>
        </el-form-item>
      </el-form>
      <el-button-group>
        <el-button type="primary" >暂存</el-button>
        <el-button type="primary" @click="submitForm('history')">提交</el-button>
        <el-button type="primary" @click="resetForm('history')">清空所有</el-button>
        <el-button type="primary">刷新</el-button>
      </el-button-group>
      <el-form :model="history" :rules="rules" ref="history">
        <el-row :gutter=50>
          <el-col :span="12">
            <el-form-item label="主诉" prop="chiefComplaint">
              <el-input v-model="history.chiefComplaint" placeholder="请填写主诉"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="现病史" prop="historyOfPresent">
              <el-input v-model="history.historyOfPresent" placeholder="请填写现病史"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-form-item label="现病治疗情况" prop="treatmentCondition">
          <el-input v-model="history.treatmentCondition" placeholder="请填写现病治疗情况"></el-input>
        </el-form-item>
        <el-form-item label="过敏史" prop="allergy">
          <el-input v-model="history.allergy" placeholder="请填写过敏史"></el-input>
        </el-form-item>
        <el-form-item label="体格检查" prop="physicalExamination">
          <el-input v-model="history.physicalExamination" placeholder="请填写体格检查"></el-input>
        </el-form-item>
      </el-form>

    </el-main>
  </el-container>
</template>

<script>
    export default {
        name: "Diagnose",
        data() {
            return {
                patientInfo: {
                    name: '',
                    medicalHistoryId: '',
                    age: '',
                },
                history: {
                    chiefComplaint: '',
                    historyOfPresent: '',
                    treatmentCondition: '',
                    allergy: '',
                    physicalExamination: '',
                },
                rules: {
                    chiefComplaint: [{ required: true, message: '请输入主诉', trigger: 'blur' },],
                    historyOfPresent: [{ required: true, message: '请输入现病史', trigger: 'blur' },],
                    treatmentCondition: [{ required: true, message: '请输入现病治疗情况', trigger: 'blur' },],
                    allergy: [{ required: true, message: '请输入过敏史', trigger: 'blur' },],
                    physicalExamination: [{ required: true, message: '请输入体格检查', trigger: 'blur' },],
                },
                finishedRegistrationTable: [],
                activeName: 'no',
                unfinishedRegistrationTable: [],
            }
        },
        mounted: function () {
            this.loadFinishedRegistration();
            this.loadUnFinishedRegistration();
        },
        methods: {
            changeState(){
                var _this=this
                var params=new URLSearchParams();
                params.append('medicalHistoryId',this.patientInfo.medicalHistoryId);
                this.$axios.post('/registration/state',params).then(resp=>{
                        if(resp){
                            this.loadFinishedRegistration();
                            this.loadUnFinishedRegistration();
                            alert("success change state")
                        }
                    })
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        var _this=this
                        this.$axios.post('/history',
                            {
                                medicalHistoryId:this.patientInfo.medicalHistoryId,
                                chiefComplaint: this.history.chiefComplaint,
                                historyOfPresent: this.history.historyOfPresent,
                                treatmentCondition: this.history.treatmentCondition,
                                allergy: this.history.allergy,
                                physicalExamination: this.history.physicalExamination,

                            }
                        ).then(resp=>{
                            if(resp){
                                alert("提交成功")
                                this.changeState();
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        alert("提交失败")
                        return false;
                    }
                });
            },
            loadFinishedRegistration() {
                var _this = this
                var params=new URLSearchParams();
                console.log(this.$store.state.id)
                params.append('doctorId',this.$store.state.id)
                this.$axios.post('/registration/finished',params).then(resp => {
                    if (resp) {
                        _this.finishedRegistrationTable = resp.data

                    }
                })
            },
            loadUnFinishedRegistration() {
                var _this = this
                var params=new URLSearchParams();
                params.append('doctorId',this.$store.state.id)
                this.$axios.post('/registration/unfinished',params).then(resp => {
                    if (resp) {
                        _this.unfinishedRegistrationTable = resp.data

                    }
                })
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            selectRow(row) {
                this.patientInfo.name = row.name;
                this.patientInfo.medicalHistoryId = row.medicalHistoryId;
                this.patientInfo.age = row.age;
                console.log(row)
            }
        }
    }
</script>

<style scoped>

</style>
