<template>
  <div id="app" class="app">
    <nav class="navbar">
      <div class="nav-brand">Vue Spring</div>
      <div class="nav-links">
        <router-link to="/" class="nav-link">Home</router-link>
        <router-link v-if="!isAuthenticated" to="/about" class="nav-link">About</router-link>
        <router-link v-if="isAuthenticated" to="/account" class="nav-link">Account</router-link>
        <router-link v-if="!isAuthenticated" to="/login" class="nav-link">Login</router-link>
      </div>
    </nav>
    <main class="container">
      <router-view />
    </main>
  </div>
</template>

<script setup lang="ts">
import { useTheme } from '@/composables/useTheme'
import { onMounted, computed } from 'vue'
import { useStore } from 'vuex'

const { initTheme } = useTheme()
const store = useStore()

const isAuthenticated = computed(() => store.getters.isAuthenticated)

onMounted(() => {
  initTheme()
})
</script>

<style scoped>
:global([data-theme="green"]) {
  --theme-color: #42b983;
}

:global([data-theme="burnt-orange"]) {
  --theme-color: #cc5500;
}

:global([data-theme="sky-blue"]) {
  --theme-color: #0ea5e9;
}

.app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.navbar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 1rem 2rem;
  background-color: #f5f5f5;
  border-bottom: 2px solid var(--theme-color);
  gap: 2rem;
}

.nav-brand {
  font-size: 1.5rem;
  font-weight: bold;
  color: var(--theme-color);
}

.nav-links {
  display: flex;
  gap: 1rem;
  flex: 1;
}

.nav-link {
  padding: 0.5rem 1rem;
  color: #333;
  text-decoration: none;
  border-radius: 4px;
  transition: all 0.3s;
}

.nav-link:hover,
.nav-link.router-link-active {
  background-color: var(--theme-color);
  color: white;
}

.container {
  flex: 1;
  padding: 2rem;
  text-align: center;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',
    'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue',
    sans-serif;
}
</style>
