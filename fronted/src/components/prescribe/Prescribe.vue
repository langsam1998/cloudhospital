<template>
  <el-container>
    <el-aside width="500px">

      <el-tabs v-model="activeName" type="border-card">
        <el-tab-pane label="已诊患者" name="yes">
          <el-form :inline="true">
            <el-form-item label="患者姓名">
              <el-input placeholder="请输入患者姓名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary">查询</el-button>
            </el-form-item>
            <el-form-item>
              <el-button type="primary">重置</el-button>
            </el-form-item>
          </el-form>
          <el-table
            :data="finishedRegistrationTable"
            ref="registrationTable"
            @row-click="selectRow"
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
          <el-form :inline="true">
            <el-form-item label="患者姓名">
              <el-input placeholder="请输入患者姓名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary">查询</el-button>
            </el-form-item>
            <el-form-item>
              <el-button type="primary">重置</el-button>
            </el-form-item>
          </el-form>
          <el-table
            :data="unfinishedRegistrationTable"
            ref="registrationTable"
            style="width: 100%"
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
      <el-row>
        <el-col :span=20>
          <el-button type="text" icon="el-icon-circle-plus" @click="addPre">增方</el-button>
          <el-button type="text" icon="el-icon-remove">删方</el-button>
          <el-button type="text" icon="el-icon-success" @click="submit">开立</el-button>
          <el-button type="text" icon="el-icon-delete-solid">作废</el-button>
          <el-button type="text" icon="el-icon-loading">刷新</el-button>
        </el-col>
        <el-col :span=4>
          <el-button type="text" icon="el-icon-plus" @click="dialogFormVisible = true">增药</el-button>
          <el-dialog title="选择药品" :visible.sync="dialogFormVisible">
            <el-form :model="addDrugs">
              <el-form-item label="药品" prop="drugsName">
              <el-select v-model="addDrugs.drug" filterable placeholder="请选择药品" >
                <el-option v-for="drug in drugs" :label="drug.drugsName" :value="drug"></el-option>
              </el-select>
              </el-form-item>
              <el-row :gutter=20>
                <el-col :span=12>
                  <el-form-item label="用法">
                    <el-input v-model="addDrugs.usage"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span=12>
                  <el-form-item label="用量">
                    <el-input v-model="addDrugs.dosage"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row :gutter=20>
                <el-col :span=12>
                  <el-form-item label="频次">
                    <el-input v-model="addDrugs.frequency"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span=12>
                  <el-form-item label="数量">
                    <el-input v-model="addDrugs.amount"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="selectedDrugs">确 定</el-button>
            </div>
          </el-dialog>
          <el-button type="text" icon="el-icon-minus">删药</el-button>
        </el-col>

      </el-row>
      <el-row :gutter=20>
        <el-col :span=8>
          <el-table
            ref="multipleTable"
            :data="prescription"
            tooltip-effect="dark"
            style="width: 100%"
          >
            <el-table-column
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column
              prop="prescriptionName"
              label="名称"
              width="120">
            </el-table-column>
            <el-table-column
              prop="state"
              label="状态"
              width="120">
            </el-table-column>
          </el-table>
        </el-col>
        <el-col :span=16>
          <el-table
            ref="multipleTable"
            :data="selectDrugs"
            tooltip-effect="dark"
            style="width: 100%"
          >
            <el-table-column
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column
              prop="drugsName"
              label="药品名称"
            >
            </el-table-column>
            <el-table-column
              prop="drugsFormat"
              label="规格"
            >

            </el-table-column>
            <el-table-column
              prop="drugsPrice"
              label="单价"
            >

            </el-table-column>
            <el-table-column
              prop="usage"
              label="用法"
            >

            </el-table-column>
            <el-table-column
              prop="dosage"
              label="用量"
            >

            </el-table-column>
            <el-table-column
              prop="frequency"
              label="频次"
            >

            </el-table-column>
            <el-table-column
              prop="amount"
              label="数量"
            >

            </el-table-column>
          </el-table>
        </el-col>
      </el-row>

    </el-main>
  </el-container>
</template>

<script>
    export default {
        name: "prescribe",
        data() {
            return {
                addDrugs:{
                    drug:'',
                    usage:'',
                    dosage:'',
                    frequency:'',
                    amount:''
                },
                selectDrugs:[],
                drugs: [],
                prescription: [],
                dialogFormVisible: false,
                patientInfo: {
                    name: '',
                    medicalHistoryId: '',
                    age: '',
                },
                finishedRegistrationTable: [],
                activeName: 'yes',
                unfinishedRegistrationTable: [],
            }
        },
        mounted: function () {
            this.loadFinishedRegistration();
            this.loadUnFinishedRegistration();
            this.loadDrugs();
        },
        methods: {
            submit(){
                this.prescription=[];
                alert("提交成功")
            },
            addPre(){
                this.selectDrugs=[];
                var pre=Array();
                pre={
                    'prescriptionName':"默认处方",
                    'state':"暂存"
                };
                this.prescription.push(pre);
                alert("添加成功")
            },
            loadDrugs(){
                var _this=this
                this.$axios.post('/drugs').then(resp=>{
                    if(resp){
                        _this.drugs=resp.data
                    }
                })
            },
            loadFinishedRegistration() {
                var _this = this
                var params = new URLSearchParams();
                console.log(this.$store.state.id)
                params.append('doctorId', this.$store.state.id)
                this.$axios.post('/registration/finished', params).then(resp => {
                    if (resp) {
                        _this.finishedRegistrationTable = resp.data

                    }
                })
            },
            loadUnFinishedRegistration() {
                var _this = this
                var params = new URLSearchParams();
                params.append('doctorId', this.$store.state.id)
                this.$axios.post('/registration/unfinished', params).then(resp => {
                    if (resp) {
                        _this.unfinishedRegistrationTable = resp.data

                    }
                })
            },
            selectRow(row) {
                this.patientInfo.name = row.name;
                this.patientInfo.medicalHistoryId = row.medicalHistoryId;
                this.patientInfo.age = row.age;
                console.log(row)
            },
            selectedDrugs(){
                this.dialogFormVisible = false;
                var selectDrug=Array();
                selectDrug=[this.addDrugs.drug,this.addDrugs.usage,this.addDrugs.dosage,this.addDrugs.frequency,this.addDrugs.amount]
                selectDrug= {
                    "drugsName":this.addDrugs.drug.drugsName,
                    "drugsFormat":this.addDrugs.drug.drugsFormat,
                    "drugsPrice":this.addDrugs.drug.drugsPrice,
                    "usage":this.addDrugs.usage,
                    "dosage":this.addDrugs.dosage,
                    "frequency":this.addDrugs.frequency,
                    "amount":this.addDrugs.amount
                }
                this.selectDrugs.push(selectDrug)
            }
        }
    }
</script>

<style scoped>

</style>
