<template>
  <div>
    <div class="info-section">
      <h3>Account Settings</h3>
      <p>Manage your account preferences and security settings.</p>
    </div>

    <div class="info-section">
      <h3>Theme Accent Color</h3>
      <p>Choose your preferred accent color for the application.</p>
      <div class="color-options">
        <button
          :class="{ 'color-option': true, active: themeColor === 'green' }"
          @click="setThemeColor('green')"
        >
          <span class="color-swatch" style="background-color: #42b983;"></span>
          Green
        </button>
        <button
          :class="{ 'color-option': true, active: themeColor === 'burnt-orange' }"
          @click="setThemeColor('burnt-orange')"
        >
          <span class="color-swatch" style="background-color: #cc5500;"></span>
          Burnt Orange
        </button>
        <button
          :class="{ 'color-option': true, active: themeColor === 'sky-blue' }"
          @click="setThemeColor('sky-blue')"
        >
          <span class="color-swatch" style="background-color: #0ea5e9;"></span>
          Sky Blue
        </button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onMounted, computed } from 'vue'
import { useStore } from 'vuex'
import { error as notifyError } from '@/utils/notify'
import { useTheme, type ThemeColor } from '@/composables/useTheme'
import { api, throwIfNotOk } from '@/utils/api'
import '@/assets/themes.css'

const store = useStore()
const user = computed(() => store.getters.user)

const { themeColor, setThemeColor: setLocalThemeColor, initTheme } = useTheme()

const setThemeColor = async (color: ThemeColor) => {
  // Update local theme first
  setLocalThemeColor(color)
  
  // Send to backend
  try {
    const response = await api.patch(`/accounts/${user.value.account.id}/branding-color`, { brandingColorCode: color })
    
    try {
      await throwIfNotOk(response)
    } catch (err: any) {
      notifyError(err?.message || 'Failed to update theme color', { timeout: false })
    }
  } catch (error) {
    notifyError('Error updating theme color', { timeout: false })
  }
}

onMounted(() => {
  initTheme()
})
</script>
