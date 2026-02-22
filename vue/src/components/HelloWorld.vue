<template>
  <div class="hello">
    <h2>{{ msg }}</h2>
    <button @click="count++">Count: {{ count }}</button>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'

defineProps<{
  msg: string
}>()

const count = ref<number>(0)
</script>

<style scoped>
.hello {
  padding: 1rem;
  margin: 1rem 0;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  padding: 0.5rem 1rem;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 1rem;
}

button:hover {
  background-color: #369970;
}
</style>
