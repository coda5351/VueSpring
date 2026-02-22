<template>
  <div class="about">
    <h2>Transform Your Customer Relationships with vuespring</h2>
    <p class="tagline">The modern, intuitive CRM solution designed to help your business grow and thrive.</p>
    
    <div class="section">
      <h3>Why Choose vuespring?</h3>
      <p>vuespring empowers your team with powerful tools to manage customer relationships, streamline operations, and drive business success. Built with cutting-edge technology, our platform delivers the performance and flexibility your business needs.</p>
    </div>

    <div class="cards-container">
      <div class="card">
        <h3>Key Features</h3>
        <ul>
          <li><strong>User Management:</strong> Effortlessly invite, manage, and assign roles to team members with our intuitive user administration system</li>
          <li><strong>Advanced Filtering & Sorting:</strong> Find exactly what you need with powerful search, filter, and sort capabilities across all your data</li>
          <li><strong>Data Export:</strong> Full control over your data with comprehensive export options for users and account information</li>
          <li><strong>Customizable Themes:</strong> Make the platform yours with multiple accent color options to match your brand</li>
          <li><strong>Secure Authentication:</strong> Enterprise-grade security with encrypted passwords and token-based authentication</li>
          <li><strong>Multi-Language Support:</strong> Reach global teams with built-in internationalization (English, Korean, and more)</li>
          <li><strong>Real-Time Notifications:</strong> Stay informed with instant toast notifications for all important actions and events</li>
          <li><strong>Password Recovery:</strong> Seamless password reset functionality ensures users never lose access</li>
        </ul>
      </div>

      <div class="card">
        <h3>Built for Performance</h3>
        <ul>
          <li>Lightning-fast interface powered by Vue 3 and Vite</li>
          <li>Type-safe codebase with TypeScript for reliability</li>
          <li>Modern Composition API for optimal code organization</li>
          <li>Responsive design that works beautifully on any device</li>
          <li>Material Design icons for intuitive navigation</li>
        </ul>
      </div>
    </div>

    <div class="cta-section">
      <h3>Ready to Get Started?</h3>
      <p>Join businesses that are already transforming their customer relationships with vuespring.</p>
      <router-link to="/register" class="cta-button">Start Your Free Trial</router-link>
    </div>
  </div>
</template>

<script setup lang="ts">
import '@/assets/themes.css'
</script>

<style scoped>
.about {
  padding: 2rem;
  max-width: 1200px;
  margin: 0 auto;
}

h2 {
  color: var(--theme-color, #42b983);
  margin-bottom: 0.5rem;
  font-size: 2rem;
}

.tagline {
  color: #666;
  font-size: 1.2rem;
  margin-bottom: 2rem;
  font-style: italic;
}

.section {
  margin-bottom: 2.5rem;
}

.section h3 {
  color: var(--theme-color, #42b983);
  margin-bottom: 1rem;
  font-size: 1.5rem;
}

.cards-container {
  display: flex;
  gap: 2rem;
  margin-bottom: 2.5rem;
}

.card {
  flex: 1;
  background: white;
  padding: 2rem;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  border: 1px solid #e6e6e6;
}

.card h3 {
  color: var(--theme-color, #42b983);
  margin-bottom: 1.5rem;
  font-size: 1.5rem;
  margin-top: 0;
}

@media (max-width: 768px) {
  .cards-container {
    flex-direction: column;
  }
}

p {
  color: #666;
  margin-bottom: 1rem;
  line-height: 1.6;
}

ul {
  list-style: none;
  padding: 0;
  color: #666;
}

li {
  padding: 0.75rem 0;
  line-height: 1.6;
}

li::before {
  content: "✓ ";
  color: var(--theme-color, #42b983);
  font-weight: bold;
  margin-right: 0.5rem;
  font-size: 1.2rem;
}

li strong {
  color: #333;
}

.cta-section {
  text-align: center;
  padding: 3rem 2rem;
  background: linear-gradient(135deg, #f5f5f5 0%, #e8e8e8 100%);
  border-radius: 12px;
  margin-top: 3rem;
}

.cta-section h3 {
  color: var(--theme-color, #42b983);
  margin-bottom: 1rem;
  font-size: 1.8rem;
}

.cta-section p {
  font-size: 1.1rem;
  margin-bottom: 2rem;
  color: #555;
}

.cta-button {
  display: inline-block;
  padding: 1rem 2.5rem;
  background-color: var(--theme-color, #42b983);
  color: white;
  text-decoration: none;
  border-radius: 6px;
  font-size: 1.1rem;
  font-weight: 600;
  transition: opacity 0.3s, transform 0.2s;
}

.cta-button:hover {
  opacity: 0.9;
  transform: translateY(-2px);
}
</style>
