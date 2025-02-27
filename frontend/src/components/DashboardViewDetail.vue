<template>

    <v-card outlined>
        <v-card-title>
            Dashboard # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="StudentId" v-model="item.studentId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="LectureId" v-model="item.lectureId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="TeacherId" v-model="item.teacherId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="Passed" v-model="item.passed" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="Submitted" v-model="item.submitted" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Achievement" v-model="item.achievement" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DashboardViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/dashboards/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

