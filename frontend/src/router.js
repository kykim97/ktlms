
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);



import DashboardView from "./components/DashboardView"
import DashboardViewDetail from "./components/DashboardViewDetail"
import RecommendationRecommendationManager from "./components/listers/RecommendationRecommendationCards"
import RecommendationRecommendationDetail from "./components/listers/RecommendationRecommendationDetail"

import StudyLectureManager from "./components/listers/StudyLectureCards"
import StudyLectureDetail from "./components/listers/StudyLectureDetail"

import UserTeacherInfoManager from "./components/listers/UserTeacherInfoCards"
import UserTeacherInfoDetail from "./components/listers/UserTeacherInfoDetail"
import UserStudentInfoManager from "./components/listers/UserStudentInfoCards"
import UserStudentInfoDetail from "./components/listers/UserStudentInfoDetail"

import Boundedcontext10121951219512196RegistrationManager from "./components/listers/Boundedcontext10121951219512196RegistrationCards"
import Boundedcontext10121951219512196RegistrationDetail from "./components/listers/Boundedcontext10121951219512196RegistrationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [

            {
                path: '/analyses/dashboards',
                name: 'DashboardView',
                component: DashboardView
            },
            {
                path: '/analyses/dashboards/:id',
                name: 'DashboardViewDetail',
                component: DashboardViewDetail
            },
            {
                path: '/recommendations/recommendations',
                name: 'RecommendationRecommendationManager',
                component: RecommendationRecommendationManager
            },
            {
                path: '/recommendations/recommendations/:id',
                name: 'RecommendationRecommendationDetail',
                component: RecommendationRecommendationDetail
            },

            {
                path: '/studies/lectures',
                name: 'StudyLectureManager',
                component: StudyLectureManager
            },
            {
                path: '/studies/lectures/:id',
                name: 'StudyLectureDetail',
                component: StudyLectureDetail
            },

            {
                path: '/users/teacherInfos',
                name: 'UserTeacherInfoManager',
                component: UserTeacherInfoManager
            },
            {
                path: '/users/teacherInfos/:id',
                name: 'UserTeacherInfoDetail',
                component: UserTeacherInfoDetail
            },
            {
                path: '/users/studentInfos',
                name: 'UserStudentInfoManager',
                component: UserStudentInfoManager
            },
            {
                path: '/users/studentInfos/:id',
                name: 'UserStudentInfoDetail',
                component: UserStudentInfoDetail
            },

            {
                path: '/boundedcontext10121951219512196s/registrations',
                name: 'Boundedcontext10121951219512196RegistrationManager',
                component: Boundedcontext10121951219512196RegistrationManager
            },
            {
                path: '/boundedcontext10121951219512196s/registrations/:id',
                name: 'Boundedcontext10121951219512196RegistrationDetail',
                component: Boundedcontext10121951219512196RegistrationDetail
            },



    ]
})
