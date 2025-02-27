<template>
    <div>
        <v-list two-line v-if="list.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    color="primary"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in list" :key="idx">
                    <template v-slot:default="{ active }">
                        <v-list-item-avatar color="primary-darker-1">
                        </v-list-item-avatar>
                        
                        <v-list-item-content>
                            <v-list-item-title>
                            </v-list-item-title>
                            <v-list-item-subtitle>
                                LectureId :  {{item.lectureId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                강의명 :  {{item.강의명 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                강의설명 :  {{item.강의설명 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                파일유형 :  {{item.파일유형 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                강사명 :  {{item.강사명 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DocumentId :  {{item.documentId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                강의상태 :  {{item.강의상태 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                강의시작일 :  {{item.강의시작일 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                강의종료일 :  {{item.강의종료일 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                수료기준 :  {{item.수료기준 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                강의분류 :  {{item.강의분류 }}
                            </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                            <v-checkbox :input-value="active" color="primary-darker-1"></v-checkbox>
                        </v-list-item-action>
                    </template>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'StudyLecturePicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/lectures'))
            if(temp.data) {
                me.list = temp.data._embedded.lectures;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/lectures/' + id))
                if(tmpValue.data) {
                    var val = tmpValue.data
                    me.list.forEach(function(item, idx) {
                        if(item.name == val.name) {
                            me.selected = idx
                        }
                    })
                }
            }
        },
        methods: {
            select(val) {
                var obj = {}
                if(val != undefined) {
                    var arr = this.list[val]._links.self.href.split('/');
                    obj['lectureId'] = arr[4]; 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

