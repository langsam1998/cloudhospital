<template>
  <el-container direction="vertical">
    <el-main>
      <el-form :inline="true" :model="lookUp">
        <el-form-item label="病历号">
          <el-input v-model="lookUp.medicalHistoryId" placeholder="请输入病历号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="reload">重置</el-button>
        </el-form-item>

      </el-form>
      <el-form :inline="true" :model="backR">
        <el-form-item label="挂号ID" prop="registrationId">
          <el-input v-model="backR.registrationId" placeholder="请选择退号记录" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="danger" @click="backRegistration">退号</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="danger" @click="resetBack">清空</el-button>
        </el-form-item>
      </el-form>
      <el-table
        :data="registrationTable"
        ref="registrationTable"
        height="400px"
        highlight-current-row
        @row-click="selectRow"
      >
        <el-table-column
          prop="id"
          label="挂号ID"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="idNumber"
          label="身份证号"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="registrationTime"
          label="挂号时间"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="medicalHistoryId"
          label="病历号"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="morningAfternoon"
          label="午别"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="departmentId"
          label="看诊科室"
          sortable
        ></el-table-column>
        <el-table-column
          prop="state"
          label="挂号状态"
          sortable
        >
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
  export default {
    data() {
      return {
        lookUp: {
          medicalHistoryId: '',
        },
        backR: {
          registrationId: '',
          state: '',
          medicalHistoryId: '',
          idNumber: '',
          name: '',
          age: '',
          ageType: '',
          address: '',
          date: '',
          morningAfternoon: '',
          gender: '',
          birthDate: '',
          departmentId: '',
          registrationLevel: '',
          doctorId: '',
          paymentType: '',
          needHistorybook: '',
          registrationFee: '',
          register: '',
          registrationTime: '',
        },
        registrationTable: []
      }
    },
    mounted: function () {
      this.loadRegistration()
    },
    methods: {
      backRegistration() {
        if (this.backR.state === "2") {
          alert("当前挂号状态为已看诊，无法退号")
        } else if (this.backR.state === "4") {
          alert("当前挂号状态为已退号，无法再次退号")
        } else {
          var _this = this
          this.$axios.post('/registration/add',
            {
              id: this.backR.registrationId,
              state: "4",
              medicalHistoryId: this.backR.medicalHistoryId,
              name: this.backR.name,
              gender: this.backR.gender,
              idNumber: this.backR.idNumber,
              birthDate: this.backR.birthDate,
              age: this.backR.age,
              ageType: this.backR.ageType,
              address: this.backR.address,
              date: this.backR.date,
              morningAfternoon: this.backR.morningAfternoon,
              departmentId: this.backR.departmentId,
              doctorId: this.backR.doctorId,
              registrationLevel: this.backR.registrationLevel,
              paymentType: this.backR.paymentType,
              needHistorybook: this.backR.needHistorybook,
              registrationTime: this.backR.registrationTime,
              register: this.backR.register,
            }
          ).then(resp => {
            if (resp) {
              alert("退号成功");
              this.loadRegistration()
            }
          })
        }

      },
      loadRegistration() {
        var _this = this
        this.$axios.get('/registration').then(resp => {
          if (resp) {
            _this.registrationTable = resp.data
          }
        })
      },
      onSubmit() {
        var _this = this
        var params = new URLSearchParams();
        params.append('medicalHistoryId', this.lookUp.medicalHistoryId);
        this.$axios.post('/registration/search', params).then(resp => {
          if (resp) {
            _this.registrationTable = resp.data
          }
        })
      },
      reload() {
        this.loadRegistration();
      },
      resetBack(){
        this.backR=[]
      },
      selectRow(row) {
        this.backR.registrationId = row.id;
        this.backR.state = row.state;
        this.backR.medicalHistoryId = row.medicalHistoryId;
        this.backR.name = row.name;
        this.backR.gender = row.gender;
        this.backR.idNumber = row.idNumber;
        this.backR.birthDate = row.birthDate;
        this.backR.age = row.age;
        this.backR.ageType = row.ageType;
        this.backR.address = row.address;
        this.backR.date = row.date;
        this.backR.morningAfternoon = row.morningAfternoon;
        this.backR.departmentId = row.departmentId;
        this.backR.doctorId = row.doctorId;
        this.backR.registrationLevel = row.registrationLevel;
        this.backR.paymentType = row.paymentType;
        this.backR.needHistorybook = row.needHistorybook;
        this.backR.registrationTime = row.registrationTime;
        this.backR.register = row.register;
        this.backR.state = row.state;
        console.log(row)
      }
    }
  }
</script>
