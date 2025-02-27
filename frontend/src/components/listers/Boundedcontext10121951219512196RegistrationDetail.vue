<template>
    <v-card outlined>
        <v-card-title>
            Registration # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="LectureId" v-model="item.lectureId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="StudentId" v-model="item.studentId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Achievement" v-model="item.achievement" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="StartingDay" v-model="item.startingDay" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="EndingDay" v-model="item.endingDay" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="Passed" v-model="item.passed" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Submitted" v-model="item.submitted" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>

        <v-card-actions>
            <v-btn text color="deep-purple lighten-2" large @click="goList">List</v-btn>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="save"
                    v-else
            >
                Save
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode"
            >
                Cancel
            </v-btn>
        </v-card-actions>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'Boundedcontext10121951219512196RegistrationDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
            editMode: false,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/registrations/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
            goList() {
                var path = window.location.href.slice(window.location.href.indexOf("/#/"), window.location.href.lastIndexOf("/#"));
                path = path.replace("/#/", "/");
                this.$router.push(path);
            },
            edit() {
                this.editMode = true;
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.item._links.self.href))
                    }

                    this.editMode = false;

                    this.$emit('input', this.item);
                    this.$emit('delete', this.item);

                } catch(e) {
                    console.log(e)
                }
            },
        },
    };
</script>
