<template>
    <div
    class="
    column 
    items-start 
    q-gutter-md 
    q-pa-md
    bg-grey-3"
    >
        <q-card v-for="x in 5" :key="x">
            <q-card-section>
            {{ x }}
            </q-card-section>
        </q-card>
    </div>
</template>

<script>
import { defineComponent, ref } from 'vue'

export default defineComponent({
    name: 'sideBar'
})

</script>

<style scoped>
    .q-card {
        width: 250px;
    }
</style>