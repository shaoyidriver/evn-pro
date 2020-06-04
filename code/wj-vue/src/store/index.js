import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      userName: localStorage.getItem('user' || '[]') != null ? JSON.parse(localStorage.getItem('user' || '[]')).userName : ''
    }
  },
  mutations: {
    editUser (state, {user}) {
      state.user = user
      localStorage.setItem('user', JSON.stringify(user))
    }
  },
  actions: {
    setUser ({ commit }, user) {
      commit('editUser', {user})
    }
  }
})
